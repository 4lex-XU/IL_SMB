package Factory;

import Interfaces.*;
import Bouchons.*;
import CAnalyse.*;
import CImpression.*;
import CLivre.*;


public class Factory {
    public Factory() {};

    public static ILivres newGestionLivre() {
        return GestionLivre.getInstance();
    }
    
    public static IImpression newImpression() {
        return new Impression();
    }
    
    public static IAnalyse newGestionAnalyse() {
        return new GestionAnalyse();
    }
    
    
    public static ILivres newBouchonGestionLivre() {
        return BouchonGestionLivre.getInstance();
    }

    public static IImpression newBouchonImpression() {
        return new BouchonImpression();
    }
    
    public static IAnalyse newBouchonGestionAnalyse() {
        return new BouchonGestionAnalyse();
    }
    
    // Pour les bouchons
    public static ILivres newGestionLivre(IAnalyse ga, IImpression gi) {
        return GestionLivre.getInstance(ga, gi);
    }


}
