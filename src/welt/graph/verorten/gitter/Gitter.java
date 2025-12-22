package welt.graph.verorten.gitter;

import graph.Nachbarschaftsliste;
import welt.graph.verorten.Verorten;

/*
  Diese Art von Verortung baut eine Gitter von Knoten auf.
*/
public class Gitter implements Verorten {
    // Die Anzahl von Kanten einer Zeile.
    public int zeileBetrag;

    // Der Weg zwischen zwei Knoten.
    public int weg;

    public Gitter(int zb, int w) {
	zeileBetrag = zb;
	weg = w;
    }

    public int[][] verorten(Nachbarschaftsliste nl) {

	// Jeder Knoten wird mit einem Ort verbunden.  Die Kanten
	// werden nicht genau bestimmt, sondern berechnet (wo?).
	int[][] orten = new int[nl.betrag][2];

	// Der Ursprung der Gitter in der Ecke.
	int[] ursprung = new int[] {0, 0};

	// Der Platz der Zeile des vorherkommenden Knoten.
	int zeileKennzeichen = 0;
	
	// Der Platz der Kolonne des vorherkommenden Konten.
	int kolonneKennzeichen = 0;

	for (int i = 0; i < nl.betrag; i++) {
	    for (int j = 0; j < this.zeileBetrag; j++) {
				
		orten[i][0] = zeileKennzeichen * this.weg;
		orten[i][1] = kolonneKennzeichen * this.weg;
		
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
