package druck.punkt;

import punkt.Zweipunkt;
import punkt.Dreipunkt;

public class Punktdrucker {
    public static String drucken(Zweipunkt p) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(p.xteil);
	sb.append(",");
	sb.append(p.yteil);
	sb.append("]");
	return sb.toString();
    }

    public static String drucken(Dreipunkt p) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(p.xteil);
	sb.append(",");
	sb.append(p.yteil);
	sb.append(",");
	sb.append(p.zteil);
	sb.append("]");
	return sb.toString();
    }
}
