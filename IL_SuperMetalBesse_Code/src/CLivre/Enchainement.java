package CLivre;

import Interfaces.IEnchainement;

import java.util.HashSet;
import java.util.Set;
import Interfaces.ISection;
import Interfaces.IObjet;


public class Enchainement implements IEnchainement {

	static private Integer nbEnchainement = 0;
	private Integer idEnchainement;
	private String description;
	private ISection tete;
	private ISection queue;
	private Set<IObjet> listePrerequis;

	
	 public Enchainement(String description, ISection tete, ISection queue) {
			this.idEnchainement = nbEnchainement++;
	        this.description = description;
	        this.tete = tete;
	        this.queue = queue;
	        this.listePrerequis = new HashSet<>();
	}
	 
	public Integer getId() {
		return idEnchainement;
	}
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public ISection getTete() {
		return tete;
	}

	@Override
	public void setTete(ISection tete) {
		this.tete = tete;
	}

	@Override
	public ISection getQueue() {
		return queue;
	}

	@Override
	public void setQueue(ISection queue) {
		this.queue = queue;
	}

	@Override
	public Set<IObjet> getListePrerequis() {
		return listePrerequis;
	}

	@Override
	public void setPrerequis(Set<IObjet> prerequis) {
		this.listePrerequis = prerequis;
		
	}
}