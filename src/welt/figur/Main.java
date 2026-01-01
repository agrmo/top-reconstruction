package welt.figur;

import punkt.Zweipunkt;
import figur.dreieck.Dreieck;
import figur.Figur;
import java.util.ArrayList;
import druck.kante.Kantedrucker;
import kante.Zweikante;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.figur.Main
*/

public class Main {
    public static void main(String[] args) {

	// Insgesamt was wir tun ist nur, den Ort eines Dreiecks zu
	// zeigen. Solches Beispiel ist nicht so einwandfrei. Wir
	// kennen unseren Raum und unsere Zeit, ohne nachzudenken,
	// warum sie so klar beleuchtet werden.
	
	// Ein Dreieck und dessen Ort.
	Dreieck k = new Dreieck(50);
	Zweipunkt p = new Zweipunkt(100,100);

	// Liste von Figuren.
	ArrayList<Figur> fl = new ArrayList<Figur>();
	fl.add(k);

	// Liste von Orten.
	ArrayList<Zweipunkt> ol = new ArrayList<Zweipunkt>();
	ol.add(p);
	
	// Mache die Welt.
	Figurwelt kw = new Figurwelt(fl, ol);

	ArrayList<Zweikante> weltKanten = kw.nehmeKanten();

	for (int i = 0; i < weltKanten.size(); i++) {
	    System.out.println(Kantedrucker.drucken(weltKanten.get(i)));
	}
    }
}
