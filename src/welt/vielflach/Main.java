package welt.vielflach;

import druck.strecke.Streckedrucker;
import java.util.ArrayList;
import vektor.Dreivektor;
import strecke.Dreistrecke;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.vielflach.Main
*/

public class Main {
    public static void main(String[] args) {

	// Insgesamt was wir tun ist nur, den Ort eines Kubus zu
	// zeigen. Solches Beispiel ist nicht so einwandfrei. Wir
	// kennen unseren Raum und unsere Zeit, ohne nachzudenken,
	// warum sie so klar beleuchtet werden.
	
	// Ein Kubus und dessen Ort.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);

	// Liste von Vielflachn.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);

	// Liste von Orten.
	ArrayList<Dreivektor> orten = new ArrayList<Dreivektor>();
	orten.add(p);
	
	// Mache die Welt.
	Vielflachwelt welt = new Vielflachwelt(kl, orten);

	// Überprüfen die Strecken.
	Dreistrecke[] strecken = welt.nehmekanten();

	for (int i = 0; i < strecken.length; i++) {
	    System.out.println(Streckedrucker.drucke(strecken[i]));
	}
    }
}
