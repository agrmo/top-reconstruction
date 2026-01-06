package druck.koerper.kubus;

import koerper.kubus.Kubus;
import druck.punkt.Punktdrucker;
import druck.strecke.Streckedrucker;
import punkt.Dreipunkt;
import strecke.Dreistrecke;

public class Kubusdrucker {
    
    public static String druckenLaenge(Kubus k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Kubus: Länge ");
	sb.append(k.laenge);
	sb.append("\n");
	return sb.toString();
    }

    public static String druckenEcken(Kubus k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Ecken:");
	Dreipunkt[] ecken = k.nehmeEcken();
	
	for (int i = 0; i < ecken.length; i++) {
	    sb.append(Punktdrucker.drucken(ecken[i]));
	}
	
	return sb.toString();
    }

    public static String druckenStrecken(Kubus k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Strecken:");	
	Dreistrecke[] strecken = k.nehmeStrecken();

	for (int i = 0; i < strecken.length; i++) {
	    sb.append(Streckedrucker.drucken(strecken[i]));
	}
	
	return sb.toString();
    }
}
