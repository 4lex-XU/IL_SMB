package CLivre;

import Interfaces.IObjet;


public class Objet implements IObjet {

	private String nom;
	
	public Objet(String nom) {this.nom = nom;}
	public String getNom() {
		return nom;
	}
}