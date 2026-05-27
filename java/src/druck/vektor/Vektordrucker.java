package druck.vektor;

import vektor.Dreivektor;
import vektor.Zweivektor;

public class Vektordrucker {
    public static String drucke(Zweivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.eins);
	sb.append(",");
	sb.append(v.zwei);
	sb.append("]");
	return sb.toString();
    }

    public static String drucke(Dreivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.eins);
	sb.append(",");
	sb.append(v.zwei);
	sb.append(",");
	sb.append(v.drei);
	sb.append("]");
	return sb.toString();
    }

    // Drucke eine Liste von Zweivektoren.
    public static String drucke(Zweivektor[] vl) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = 0; i < vl.length; i++) {
	    sb.append(Vektordrucker.drucke(vl[i]));
	    if (i + 1 != vl.length) {
		sb.append(",");
	    }
	}
	sb.append("]");

	return sb.toString();
    }
}
