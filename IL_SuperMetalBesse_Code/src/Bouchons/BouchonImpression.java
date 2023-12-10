/**
 * 
 */
package Bouchons;

import Interfaces.IImpression;

public class BouchonImpression implements IImpression {

	public BouchonImpression() {}
	
	public Boolean genererHTML(String titreLivre, String nom) {
		return true;
	}


	public Boolean genererPDF(String titreLivre, String nom) {
		return true;
	}
	
}