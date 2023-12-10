/**
 * 
 */
package CLivre;

import Interfaces.ILivre;

import java.util.HashSet;
import java.util.Set;
import Interfaces.IObjet;
import Interfaces.ISection;
import Interfaces.IEnchainement;


public class Livre implements ILivre {
	
	private String titre;
	private String auteur;
	private Set<ISection> listeSection;
	private Set<IEnchainement> listeEnchainement;
	private Set<IObjet> listeObjetDefinis;

	 public Livre(String titre, String auteur) {
		 	this.titre = titre;
	        this.auteur = auteur;
	        this.listeSection = new HashSet<>();
	        this.listeEnchainement = new HashSet<>();
	        this.listeObjetDefinis = new HashSet<>();
	}
	 
	@Override
	public String getTitre() {
		return titre;
	}

	@Override
	public String getAuteur() {
		return auteur;
	}

	@Override
	public Set<IObjet> getListeObjets() {
		return listeObjetDefinis;
	}

	@Override
	public Boolean verifObjetExist(String nomObjet) {
		Boolean exist= false;
		for (IObjet o :listeObjetDefinis) {
			if(nomObjet == o.getNom()) exist = true;
		}
		return exist;
	}

	@Override
	public Boolean addObjet(String nomObjet) {
		listeObjetDefinis.add(new Objet(nomObjet));
		return true;
	}

	@Override
	public void removeObjet(IObjet nomObjet) {
		IObjet objetasupprimer = null;
		for (IObjet o :listeObjetDefinis) {
			if(nomObjet.getNom() == o.getNom()) {
				objetasupprimer = o;
				break;
			}
		}
		listeObjetDefinis.remove(objetasupprimer);
	}

	@Override
	public Set<ISection> getListeSections() {
		return listeSection;
	}

	@Override
	public Boolean verifPremiereSection() {
		return listeSection.size() == 0;
	}

	@Override
	public Integer addSection(Boolean isDebut) {
		Section newsection = new Section(isDebut);
		listeSection.add(newsection);
		return newsection.getId();
	}

	@Override
    public Boolean setSection(Integer idSection, String texte, Boolean isFin, Set<IObjet> listeObjet) {
        //on recupere la section
        for (ISection s : listeSection) {
            if (s.getId()==idSection) {
                s.setTexte(texte);
                s.setFin(isFin);
                s.setListeObjets(listeObjet);
                return true;
            } 
        }
        return false;
    }

	@Override
	public Boolean removeSection(Integer idSection) {
		for (ISection s : listeSection) {
			if (s.getId()==idSection) {
				//si c'est la premiere section on empeche la suppression
				if(s.getIsDebut())  return false;
				// supprimer enchainement list
				return s.supprimerEnchainementsLies();
			}
		}
		return false;
	}

	@Override
	public Set<IEnchainement> getListeEnchainements() {
		return listeEnchainement;
	}

	@Override
	public Integer addEnchainement(Integer idTete, Integer idQueue) {
		ISection tete = null;
		ISection queue = null;
		for (ISection s : listeSection) {
			if (s.getId()==idTete) tete = s;
			if (s.getId()==idQueue) queue = s;
		}
		IEnchainement newenchainement = new Enchainement("", tete, queue);
		this.listeEnchainement.add(newenchainement);
		return newenchainement.getId();
	}

	@Override
	public Boolean setEnchainement(Integer idEnchainement, Integer idTete, Integer idQueue, String description, Set<IObjet> prerequis) {
		ISection tete = null;
		ISection queue = null;
		for (ISection s : listeSection) {
			if (s.getId()==idTete) tete = s;
			if (s.getId()==idQueue) queue = s;
		}
		for (IEnchainement e : listeEnchainement) {
			if (e.getId()==idEnchainement) {
				e.setDescription(description);
				e.setQueue(queue);
				e.setTete(tete);
				e.setPrerequis(prerequis);
			}
		}
		return true;
	}

	@Override
	public Boolean removeEnchainement(Integer idEnchainement) {
		IEnchainement enchainementasupprimer = null;
		for (IEnchainement e : listeEnchainement) {
			if (e.getId()==idEnchainement) {
				enchainementasupprimer = e;
				break;
			}
				
		}
		return listeEnchainement.remove(enchainementasupprimer);
	}
}