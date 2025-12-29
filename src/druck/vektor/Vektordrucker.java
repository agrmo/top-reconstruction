package druck.vektor;

import vektor.Zweivektor;
import vektor.Dreivektor;

public class Vektordrucker {
    public static String drucken(Zweivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.eins);
	sb.append(",");
	sb.append(v.zwei);
	sb.append("]");
	return sb.toString();
    }

    public static String drucken(Dreivektor v) {
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
