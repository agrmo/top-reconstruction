package druck.vielflach;

import druck.punkt.Punktdrucker;
import druck.strecke.Streckedrucker;
import punkt.Dreipunkt;
import strecke.Dreistrecke;
import vielflach.Vielflach;

public class Vielflachdrucker {
    
    public static String druckenEcken(Vielflach k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Ecken:");
	Dreipunkt[] ecken = k.nehmeecken();
	
	for (int i = 0; i < ecken.length; i++) {
	    sb.append("\n");
	    sb.append(Punktdrucker.drucken(ecken[i]));
	}
	
	return sb.toString();
    }

    public static String druckenStrecken(Vielflach k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Strecken:");	
	Dreistrecke[] strecken = k.nehmekanten();

	for (int i = 0; i < strecken.length; i++) {
	    sb.append("\n");
	    sb.append(Streckedrucker.drucken(strecken[i]));
	}
	
	return sb.toString();
    }
}
