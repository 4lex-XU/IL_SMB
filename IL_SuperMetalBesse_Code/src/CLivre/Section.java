package CLivre;

import Interfaces.IObjet;
import Interfaces.ISection;

import java.util.HashSet;
import java.util.Set;


public class Section implements ISection {

	static private Integer nbSection=0;
	private Integer idSection;
	private String texte;
	private Boolean isDebut;
	private Boolean isFin;
	private Set<IObjet> objetsObtenus;
	private Boolean isAccessible;
	private Set<Enchainement> listeEnchainements;
	
	
	 public Section(Boolean isDebut) {
	        this.idSection = nbSection++;
	        this.texte = "a remplir";
	        this.isDebut = isDebut;
	        this.isFin = false;
	        this.objetsObtenus = new HashSet<>();
	        this.isAccessible = false;
	        this.listeEnchainements = new HashSet<>();
	        
	    }
	 
	@Override
	public String getTexte() {
		return texte;
	}
	public Integer getId() {
		return idSection;
	}

	@Override
	public void setTexte(String texte) {
		this.texte = texte;
	}


	@Override
	public Boolean getIsDebut() {
		return isDebut;
	}


	@Override
	public Boolean getIsFin() {
		return isFin;
	}


	@Override
	public void setFin(Boolean isFin) {
		this.isFin = isFin;
	}


	@Override
	public Boolean getIsAccessible() {
		return isAccessible;
	}

	@Override
	public Set<IObjet> getObjetsObtenus() {
		return objetsObtenus;
	}
	
	@Override
	public void setListeObjets(Set<IObjet> listeObjets) {
		this.objetsObtenus = listeObjets;
	}

	@Override
	public Boolean supprimerEnchainementsLies() {
		this.listeEnchainements.clear();
		return true;
	}
	
}