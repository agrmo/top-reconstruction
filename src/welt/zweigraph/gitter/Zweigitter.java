package welt.zweigraph.gitter;

import graph.Nachbarschaftsliste;
import punkt.Zweipunkt;

/*
  Diese Art von Verortung baut eine Gitter von Knoten auf.
  
  Wie können wir die Orten eines Graphen bestimmen, wenn am Anfang es
  keine Orten gibt? Nehmen wir eine Menge von Grundlagen an, mit denen
  wir die Orten berechnen werden.
*/  
public class Zweigitter {

    // zeileBetrag: Die Anzahl von Strecken einer Zeile.
    // weg: Der Weg zwischen zwei Knoten.
    public static Zweipunkt[] machen(Nachbarschaftsliste nl,
				     int zeileBetrag,
				     int weg) {

	// Jeder Knoten wird mit einem Ort verbunden.  Die Strecken
	// werden nicht genau bestimmt, sondern berechnet.
	Zweipunkt[] orten = new Zweipunkt[nl.betrag];

	// Der Platz der Zeile des vorherkommenden Knoten.
	int zeileKennzeichen = 0;
	
	// Der Platz der Kolonne des vorherkommenden Konten.
	int kolonneKennzeichen = 0;

	for (int i = 0; i < nl.betrag; i++) {
	    for (int j = 0; j < zeileBetrag; j++) {

		orten[i] = new Zweipunkt(zeileKennzeichen * weg,
					 kolonneKennzeichen * weg);
		
		if (zeileKennzeichen > zeileBetrag) {
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
