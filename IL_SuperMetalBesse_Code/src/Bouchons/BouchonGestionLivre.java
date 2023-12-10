package Bouchons;

import Interfaces.ILivres;

import java.util.Set;

import CAnalyse.GestionAnalyse;
import CImpression.Impression;
import Interfaces.IAnalyse;
import Interfaces.IImpression;
import Interfaces.ILivre;
import Interfaces.IObjet;


public class BouchonGestionLivre implements ILivres {

	private static BouchonGestionLivre instance;

	private BouchonGestionLivre(IAnalyse ga, IImpression gi) {}

    // M�thode publique statique pour obtenir l'instance
    public static BouchonGestionLivre getInstance() {
        if (instance == null) {
            instance = new BouchonGestionLivre(new GestionAnalyse(), new Impression());
        }
        return instance;
    }
    
	@Override
	public Set<ILivre> getListeLivres() {
		return null;
	}

	@Override
	public Boolean creerLivre(String titreLivre, String auteur) {
		return true;
	}
	
	
	@Override
    public Boolean ouvrirLivre(String titreLivre) {
        return true;
    }

	@Override
	public Boolean verifLivreExist(String titreLivre) {
		return true;
	}

	@Override
	public Boolean creerObjet(String nom) {
		return true;
	}

	@Override
	public Boolean supprimerObjet(String nom) {
		return true;
	}

	@Override
	public Integer creerSection() {
		return 0;
	}

	@Override
	public Boolean modifierSection(Integer idSection, String texte, Boolean isFin, Set<IObjet> listeObjets) {
		return true;
	}

	@Override
	public Boolean supprimerSection(Integer idSection) {
		return true;
		
	}

	@Override
	public Integer creerEnchainement(Integer idTete, Integer idQueue) {
		return 0;
	}

	@Override
	public Boolean modifierEnchainement(Integer idEnchainement, Integer idTete, Integer idQueue, String description, Set<IObjet> prerequis) {
		return true;
	}

	@Override
	public Boolean supprimerEnchainement( Integer idEnchainement) {
		return true;
	}

	@Override
	public Boolean genererPDF(String titreLivre, String nom) {
		return true;
	}

	@Override
	public Boolean genererHTML(String titreLivre, String nom) {
		return true;
	}

	@Override
	public ILivre getLivreOuvert() {
		return null;
	}
}