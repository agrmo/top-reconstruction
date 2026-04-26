package druck.bogen;

import bogen.Bogen;

public class Bogendrucker {
    
    public static String drucke(Bogen b) {
	StringBuilder sb = new StringBuilder();

	sb.append("Bogen: Breite ");
	sb.append(b.breite);
	sb.append(", Hoehe ");
	sb.append(b.hoehe);
	sb.append(", von ");
	sb.append(b.anfangswinkel);
	sb.append(" bis ");
	sb.append(b.unterschiedwinkel);
	sb.append("\n");
	
	return sb.toString();
    }
}
