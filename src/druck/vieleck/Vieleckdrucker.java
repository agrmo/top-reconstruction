package druck.vieleck;

import druck.vektor.Vektordrucker;
import vieleck.Vieleck;
import vektor.Zweivektor;

public class Vieleckdrucker {
    public static String drucken(Vieleck v) {
	StringBuilder sb = new StringBuilder();	
	sb.append("[");

	Zweivektor[] ecken = v.nehmeecken();
	
	for (int i = 0; i < ecken.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Vektordrucker.drucken(ecken[i]));
	}
	
	sb.append("]");

	return sb.toString();
    }
}
