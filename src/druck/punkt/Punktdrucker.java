package druck.punkt;

import punkt.Zweipunkt;
import punkt.Dreipunkt;

public class Punktdrucker {
    public static String drucken(Zweipunkt p) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(p.eins);
	sb.append(",");
	sb.append(p.zwei);
	sb.append("]");
	return sb.toString();
    }

    public static String drucken(Dreipunkt p) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(p.eins);
	sb.append(",");
	sb.append(p.zwei);
	sb.append(",");
	sb.append(p.drei);
	sb.append("]");
	return sb.toString();
    }
}
