package druck.figur.vieleck;

import druck.vektor.Vektordrucker;
import druck.punkt.Punktdrucker;
import figur.vieleck.Vieleck;

public class Vieleckdrucker {
    public static String drucken(Vieleck v) {
	StringBuilder sb = new StringBuilder();	
	sb.append("[");
	
	for (int i = 0; i < v.ecken.size(); i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Punktdrucker.drucken(v.ecken.get(i)));
	}
	
	sb.append("]");

	return sb.toString();
    }
}
