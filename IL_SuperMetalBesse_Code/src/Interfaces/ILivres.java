package Interfaces;

import java.util.Set;

public interface ILivres {
	public Set<ILivre> getListeLivres();
	public Boolean creerLivre(String titreLivre, String auteur);
	public Boolean ouvrirLivre(String titreLivre);
	public Boolean verifLivreExist(String titreLivre);
	public Boolean creerObjet(String nom);
	public Boolean supprimerObjet(String nom);
	public Integer creerSection();
	public Boolean modifierSection(Integer idSection, String texte, Boolean isFin, Set<IObjet> listeObjets);
	public Boolean supprimerSection(Integer idSection);
	public Integer creerEnchainement(Integer idTete, Integer idQueue);
	public Boolean modifierEnchainement(Integer idEnchainement, Integer idTete, Integer idQueue, String description, Set<IObjet> prerequis);
	public Boolean supprimerEnchainement(Integer idEnchainement);
	public Boolean genererPDF(String titreLivre, String nom);
	public Boolean genererHTML(String titreLivre, String nom);
	public ILivre getLivreOuvert();
}