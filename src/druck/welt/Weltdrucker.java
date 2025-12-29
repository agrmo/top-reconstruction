package druck.welt;

import welt.kante.Zweikantewelt;

public class Weltdrucker {
    
    public static String drucken(Zweikantewelt zkw) {
	StringBuilder sb = new StringBuilder();
	sb.append("Kanten dieser Welt:\n");

	for (int i = 0; i < zkw.kantenliste.size(); i++) {
	    String ks = zkw.kantenliste.get(i).drucken();
	    sb.append(ks);
	    sb.append("\n");
	}
	return sb.toString();
    }
}
