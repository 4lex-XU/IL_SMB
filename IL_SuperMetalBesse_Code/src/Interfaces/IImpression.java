package Interfaces;

public interface IImpression {
	public Boolean genererHTML(String titreLivre, String nom);
	public Boolean genererPDF(String titreLivre, String nom);
}