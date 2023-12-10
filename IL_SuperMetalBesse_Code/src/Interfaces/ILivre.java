package Interfaces;

import java.util.Set;

public interface ILivre {
	public String getTitre();
	public String getAuteur();
	public Set<IObjet> getListeObjets();
	public Boolean verifObjetExist(String nomObjet);
	public Boolean addObjet(String nomObjet);
	public void removeObjet(IObjet nomObjet);
	public Set<ISection> getListeSections();
	public Boolean verifPremiereSection();
	public Integer addSection(Boolean isDebut);
	public Boolean setSection(Integer idSection, String texte, Boolean isFin, Set<IObjet> listeObjet);
	public Boolean removeSection(Integer idSection);
	public Set<IEnchainement> getListeEnchainements();
	public Integer addEnchainement(Integer idTete, Integer idQueue);
	public Boolean setEnchainement(Integer idEnchainement, Integer idTete, Integer idQueue, String description, Set<IObjet> prerequis);
	public Boolean removeEnchainement(Integer idEnchainement);
}