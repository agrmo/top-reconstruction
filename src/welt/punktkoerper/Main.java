package welt.punktkoerper;

import punkt.Dreipunkt;
import koerper.kubus.Kubus;
import punktkoerper.kubus.Punktkubus;
import punktkoerper.Punktkoerper;
import java.util.ArrayList;

/*
  javac -d classes $(find src -name '*.java')
  java -cp classes welt.punktkoerper.Main
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
	Punktkubus pk = new Punktkubus(k, p);

	// Liste von Koerpern.
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	
	// Mache die Welt.
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);
    }
}
