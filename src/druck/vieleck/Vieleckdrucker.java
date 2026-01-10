package druck.vieleck;

import druck.punkt.Punktdrucker;
import vieleck.Vieleck;
import punkt.Zweipunkt;

public class Vieleckdrucker {
    public static String drucken(Vieleck v) {
	StringBuilder sb = new StringBuilder();	
	sb.append("[");

	Zweipunkt[] ecken = v.nehmeecken();
	
	for (int i = 0; i < ecken.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Punktdrucker.drucken(ecken[i]));
	}
	
	sb.append("]");

	return sb.toString();
    }
}
