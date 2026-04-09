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
}
