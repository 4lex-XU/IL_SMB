/**
 * 
 */
package CImpression;

import Interfaces.IImpression;

public class Impression implements IImpression {

	public Impression() {}
	public Boolean genererHTML(String titreLivre, String nom) {
		return true;
	}


	public Boolean genererPDF(String titreLivre, String nom) {
		return true;
	}
	
}