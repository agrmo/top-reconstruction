package druck.koerper.kubus;

import koerper.kubus.Kubus;
import punktkoerper.Punktkoerper;
import druck.punkt.Punktdrucker;
import druck.kante.Kantedrucker;
import punkt.Dreipunkt;
import kante.Dreikante;

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

    public static String druckenKanten(Kubus k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Kanten:");	
	Dreikante[] kanten = k.nehmeKanten();

	for (int i = 0; i < kanten.length; i++) {
	    sb.append(Kantedrucker.drucken(kanten[i]));
	}
	
	return sb.toString();
    }
}
