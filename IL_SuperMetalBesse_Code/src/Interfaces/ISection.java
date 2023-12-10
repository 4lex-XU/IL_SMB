package Interfaces;

import java.util.Set;

public interface ISection {
	public String getTexte();
	public void setTexte(String texte);
	public Boolean getIsDebut();
	public Boolean getIsFin();
	public void setFin(Boolean isFin);
	public Boolean getIsAccessible();
	public Set<IObjet> getObjetsObtenus();
	public void setListeObjets(Set<IObjet> listeObjets);
	public Boolean supprimerEnchainementsLies();
    public Integer getId();
}