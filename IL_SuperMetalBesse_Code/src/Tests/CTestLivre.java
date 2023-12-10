
package Tests;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import CLivre.*;
import Factory.Factory;
import Interfaces.*;

public class CTestLivre {

	@Test
	void testLivre() {
		
		IAnalyse mock_Analyse = Factory.newGestionAnalyse();
		IImpression mock_Impression = Factory.newImpression();
		ILivres s = Factory.newGestionLivre(mock_Analyse, mock_Impression);

		assertFalse(s.verifLivreExist("SMB"));
		assertTrue(s.creerLivre("SMB", "Alex"));
		ILivre l = s.getLivreOuvert();

		assertEquals("Alex",l.getAuteur());
		assertFalse(l.verifObjetExist("baton"));
		assertTrue(l.verifPremiereSection());
		assert 0 == l.addSection(true);
		Set<IObjet> objets = new HashSet<>();
		objets.add(new Objet("couteau"));
		assertTrue(l.setSection(0,"entrer",false,objets));
		assert 1 == l.addSection(false);
		Set<IObjet> objets2 = new HashSet<>();
		objets2.add(new Objet("fourchette"));
		assertFalse(l.setSection(99,"manger les plats",true,objets2));
		assert 0 == l.addEnchainement(0,1);

	}

}

