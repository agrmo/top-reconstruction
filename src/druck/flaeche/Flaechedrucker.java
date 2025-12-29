package druck.flaeche;

import kante.Zweikante;
import kante.Dreikante;
import druck.punkt.Punktdrucker;
import flaeche.Flaeche;
import punkt.Dreipunkt;

public class Flaechedrucker {
    public static String drucken(Flaeche f) {
	StringBuilder sb = new StringBuilder();

	sb.append("Fläche: ");
	sb.append("[");
	
	for (int i = 0; i < f.punktliste.size(); i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Punktdrucker.drucken(f.punktliste.get(i)));
	}
	
	sb.append("]");

	return sb.toString();
    }
}
