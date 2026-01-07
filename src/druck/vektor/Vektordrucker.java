package druck.vektor;

import vektor.Dreivektor;
import vektor.Zweivektor;

public class Vektordrucker {
    public static String drucken(Zweivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.xteil);
	sb.append(",");
	sb.append(v.yteil);
	sb.append("]");
	return sb.toString();
    }

    public static String drucken(Dreivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.xteil);
	sb.append(",");
	sb.append(v.yteil);
	sb.append(",");
	sb.append(v.zteil);
	sb.append("]");
	return sb.toString();
    }
}
