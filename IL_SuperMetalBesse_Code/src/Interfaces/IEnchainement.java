package Interfaces;

import java.util.Set;

public interface IEnchainement {
	
	public String getDescription();
	public void setDescription(String description);

	public ISection getTete();
	public void setTete(ISection tete);
	
	public ISection getQueue();
	public void setQueue(ISection queue);

	public Set<IObjet> getListePrerequis();
	public void setPrerequis(Set<IObjet> prerequis);
    public Integer getId();
}