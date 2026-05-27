package druck.vielflach;

import druck.vektor.Vektordrucker;
import druck.strecke.Streckedrucker;
import vektor.Dreivektor;
import strecke.Dreistrecke;
import vielflach.Vielflach;

public class Vielflachdrucker {
    
    public static String druckeecken(Vielflach k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Ecken:");
	Dreivektor[] ecken = k.nehmeecken();
	
	for (int i = 0; i < ecken.length; i++) {
	    sb.append("\n");
	    sb.append(Vektordrucker.drucke(ecken[i]));
	}
	
	return sb.toString();
    }

    public static String druckestrecken(Vielflach k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Strecken:");	
	Dreistrecke[] strecken = k.nehmekanten();

	for (int i = 0; i < strecken.length; i++) {
	    sb.append("\n");
	    sb.append(Streckedrucker.drucke(strecken[i]));
	}
	
	return sb.toString();
    }
}
