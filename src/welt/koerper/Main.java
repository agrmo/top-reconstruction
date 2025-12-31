package welt.koerper;

import punkt.Dreipunkt;
import koerper.kubus.Kubus;
import koerper.Koerper;
import java.util.ArrayList;
import druck.kante.Kantedrucker;
import kante.Dreikante;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.koerper.Main
*/

public class Main {
    public static void main(String[] args) {

	// Insgesamt was wir tun ist nur, den Ort eines Kubus zu
	// zeigen. Solches Beispiel ist nicht so einwandfrei. Wir
	// kennen unseren Raum und unsere Zeit, ohne nachzudenken,
	// warum sie so klar beleuchtet werden.
	
	// Ein Kubus und dessen Ort.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);

	// Liste von Koerpern.
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);

	// Liste von Orten.
	ArrayList<Dreipunkt> orten = new ArrayList<Dreipunkt>();
	orten.add(p);
	
	// Mache die Welt.
	Koerperwelt kw = new Koerperwelt(kl, orten);

	// Überprüfen die Kanten.
	ArrayList<Dreikante> weltKanten = kw.nehmeKanten();

	for (int i = 0; i < weltKanten.size(); i++) {
	    System.out.println(Kantedrucker.drucken(weltKanten.get(i)));
	}
    }
}
