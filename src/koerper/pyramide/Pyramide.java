package koerper.pyramide;

import koerper.Koerper;
import verdoppler.punkt.Punktverdoppler;
import strecke.Dreistrecke;
import punkt.Dreipunkt;

// Die Pyramide.
public class Pyramide extends Koerper {

    // Die Länge einer Seite der Bodenfläche.
    int laenge;

    // Die Höhe der Pyramide.
    int hoehe;

    public Pyramide(int l, int h) {
	this.laenge = l;
	this.hoehe = h;
    }

    public int nehmeeckeanzahl() {
	return 5;
    }

    public Dreipunkt[] nehmeecken() {

	Dreipunkt[] ecken = new Dreipunkt[5];

	ecken[0] = new Dreipunkt(0,0,0);
	ecken[1] = new Dreipunkt(0,this.laenge,0);
	ecken[2] = new Dreipunkt(this.laenge,this.laenge,0);
	ecken[3] = new Dreipunkt(this.laenge,0,0);
	ecken[4] = new Dreipunkt(this.laenge / 2.0, this.laenge / 2.0, this.hoehe);

	return ecken;
    }
    
    public int nehmekantenanzahl() {
	return 8;
    }
    
    public Dreistrecke[] nehmekanten() {

	Dreistrecke[] strecken = new Dreistrecke[8];

	Dreipunkt[] ecken = this.nehmeecken();

	int[][] streckenzeichen = new int[][] {{0,1},{1,2},{2,3},{3,0},
					       {0,4},{1,4},{2,4},{3,4}};

	for (int i = 0; i < streckenzeichen.length; i++) {
	    strecken[i] = new Dreistrecke(Punktverdoppler.verdoppeln(ecken[streckenzeichen[i][0]]),
					  Punktverdoppler.verdoppeln(ecken[streckenzeichen[i][1]])); 
	}

	// Wir sollen die Punkte verdoppeln, sodaß die Zeiger der
	// Strecken nicht voneinander abhängig sind. Das ist viel
	// einfacher in einem Programm.

	return strecken;
    }
}
