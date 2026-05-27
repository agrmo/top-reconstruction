package welt.vieleck;

import vektor.Zweivektor;
import vieleck.dreieck.Dreieck;
import vieleck.Vieleck;
import druck.strecke.Streckedrucker;
import strecke.Zweistrecke;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.vieleck.Main
*/

public class Main {
    public static void main(String[] args) {

	// Insgesamt was wir tun ist nur, den Ort eines Dreiecks zu
	// zeigen. Wir kennen unseren Raum und unsere Zeit, ohne
	// nachzudenken, warum sie so klar beleuchtet werden.
	
	// Ein Dreieck und dessen Ort.
	Dreieck k = new Dreieck(50);
	Zweivektor p = new Zweivektor(100,100);

	// Liste von Vielecken.
	Vieleck[] fl = new Vieleck[] {k};

	// Liste von Orten.
	Zweivektor[] ol = new Zweivektor[] {p};
	
	// Mache die Welt.
	Vieleckwelt welt = new Vieleckwelt(fl, ol);

	// Drucken ihre Kanten
	Zweistrecke[] strecken = welt.nehmekanten();

	for (int i = 0; i < strecken.length; i++) {
	    System.out.println(Streckedrucker.drucke(strecken[i]));
	}
    }
}
