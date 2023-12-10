package CLivre;

import Interfaces.ILivres;

import java.util.HashSet;
import java.util.Set;

import CAnalyse.GestionAnalyse;
import CImpression.Impression;
import Interfaces.IAnalyse;
import Interfaces.IImpression;
import Interfaces.ILivre;
import Interfaces.IObjet;


public class GestionLivre implements ILivres {

	private static GestionLivre instance;
	private Set<ILivre> livres;
	private IAnalyse ga;
	private IImpression gi;
	private ILivre livreOuvert; 

	private GestionLivre(IAnalyse ga, IImpression gi) {
		this.livres = new HashSet<>();
		this.ga = ga;
		this.gi = gi;
		this.livreOuvert = null;
	}

    // M�thode publique statique pour obtenir l'instance
    public static GestionLivre getInstance() {
        if (instance == null) {
            instance = new GestionLivre(new GestionAnalyse(), new Impression());
        }
        return instance;
    }
 
    
	@Override
	public Set<ILivre> getListeLivres() {
		return livres;
	}

	@Override
	public Boolean creerLivre(String titreLivre, String auteur) {
		if (this.verifLivreExist(titreLivre)) return false;
		Livre newlivre = new Livre(titreLivre,auteur);
		livres.add(newlivre);
		this.ouvrirLivre(titreLivre);
		return true;
	}
	
	
	@Override
    public Boolean ouvrirLivre(String titreLivre) {
        for (ILivre livre : livres) {
            if (livre.getTitre().equals(titreLivre)) {
                this.livreOuvert = livre;
                return true;
            }
        }
        return false;
    }

	@Override
	public Boolean verifLivreExist(String titreLivre) {
		Boolean b = false;
		for (ILivre livre : livres) {
			if (livre.getTitre() == titreLivre) b = true;
		}
		return b;
	}

	@Override
	public Boolean creerObjet(String nom) {
		if (livreOuvert.verifObjetExist(nom)) return false;
		return livreOuvert.addObjet(nom);
	}

	@Override
	public Boolean supprimerObjet(String nom) {
		IObjet objetasupprimer = null;
		for (IObjet o :livreOuvert.getListeObjets()) {
			if(nom == o.getNom()) {
				objetasupprimer = o;
				break;
			}
		}
		livreOuvert.removeObjet(objetasupprimer);
		return true;
	}

	@Override
	public Integer creerSection() {
		Boolean isDebut = livreOuvert.verifPremiereSection();
		return livreOuvert.addSection(isDebut);
	}

	@Override
	public Boolean modifierSection(Integer idSection, String texte, Boolean isFin, Set<IObjet> listeObjets) {
		return livreOuvert.setSection( idSection,  texte, isFin,  listeObjets);
	}

	@Override
	public Boolean supprimerSection(Integer idSection) {
		Boolean b = livreOuvert.removeSection(idSection);
		ga.analyseGraphe(livreOuvert.getTitre());
		return b;
		
	}

	@Override
	public Integer creerEnchainement(Integer idTete, Integer idQueue) {
		return livreOuvert.addEnchainement( idTete,  idQueue);
	}

	@Override
	public Boolean modifierEnchainement(Integer idEnchainement, Integer idTete, Integer idQueue, String description, Set<IObjet> prerequis) {
		Boolean b= livreOuvert.setEnchainement(idEnchainement, idTete,  idQueue,description,  prerequis) ;
		ga.analyseGraphe(livreOuvert.getTitre());
		return b;
	}

	@Override
	public Boolean supprimerEnchainement( Integer idEnchainement) {
		Boolean b =  livreOuvert.removeEnchainement(idEnchainement);
		ga.analyseGraphe(livreOuvert.getTitre());
		return b;
	}

	@Override
	public Boolean genererPDF(String titreLivre, String nom) {
		// on appel du code qui genere le PDF
		return gi.genererPDF(titreLivre, nom);
	}

	@Override
	public Boolean genererHTML(String titreLivre, String nom) {
		// on appel du code qui genere le HTML
		return gi.genererHTML(titreLivre, nom);
	}

	@Override
	public ILivre getLivreOuvert() {
		return livreOuvert;
	}
	
	
	 // Avec les bouchons
    public static GestionLivre getInstance(IAnalyse ga, IImpression gi) {
        if (instance == null) {
            instance = new GestionLivre(ga, gi);
        }
        return instance;
    }
}