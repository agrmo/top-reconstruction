package welt.graph.macher.gitter;

import graph.Nachbarschaftsliste;
import punkt.Zweipunkt;

/*
  Diese Art von Verortung baut eine Gitter von Knoten auf.
  
  Wie können wir die Orten eines Graphen bestimmen, wenn am Anfang es
  keine Orten gibt? Nehmen wir eine Menge von Grundlagen an, mit denen
  wir die Orten berechnen werden.
*/  
public class Gitter {
    // Die Anzahl von Strecken einer Zeile.
    public int zeileBetrag;

    // Der Weg zwischen zwei Knoten.
    public int weg;

    public Gitter(int zb, int w) {
	zeileBetrag = zb;
	weg = w;
    }

    public Zweipunkt[] machen(Nachbarschaftsliste nl) {

	// Jeder Knoten wird mit einem Ort verbunden.  Die Strecken
	// werden nicht genau bestimmt, sondern berechnet.
	Zweipunkt[] orten = new Zweipunkt[nl.betrag];

	// Der Platz der Zeile des vorherkommenden Knoten.
	int zeileKennzeichen = 0;
	
	// Der Platz der Kolonne des vorherkommenden Konten.
	int kolonneKennzeichen = 0;

	for (int i = 0; i < nl.betrag; i++) {
	    for (int j = 0; j < this.zeileBetrag; j++) {

		orten[i] = new Zweipunkt(zeileKennzeichen * this.weg,
					 kolonneKennzeichen * this.weg);
		
		if (zeileKennzeichen > this.zeileBetrag) {
		    zeileKennzeichen = 0;
		} else {
		    zeileKennzeichen += 1;
		}

		kolonneKennzeichen += 1;		
	    }
	}

	return orten;
    }
}
