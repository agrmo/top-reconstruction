package vielflach.pyramide;

import vielflach.Vielflach;
import verdoppler.vektor.Vektorverdoppler;
import strecke.Dreistrecke;
import vektor.Dreivektor;

// Die Pyramide.
public class Pyramide extends Vielflach {

    // Die Länge einer Seite der Bodenfläche.
    int laenge;

    // Die Höhe der Pyramide.
    int hoehe;

    public Pyramide(int l, int h) {
	this.laenge = l;
	this.hoehe = h;
    }

    public int nehmeeckenanzahl() {
	return 5;
    }

    public int nehmekantenanzahl() {
	return 8;
    }

    public Dreivektor[] nehmeecken() {

	Dreivektor[] ecken = new Dreivektor[5];
	ecken[0] = new Dreivektor(0,0,0);
	ecken[1] = new Dreivektor(0,this.laenge,0);
	ecken[2] = new Dreivektor(this.laenge,this.laenge,0);
	ecken[3] = new Dreivektor(this.laenge,0,0);
	ecken[4] = new Dreivektor(this.laenge / 2.0, this.laenge / 2.0, this.hoehe);

	return ecken;
    }
    
    public Dreistrecke[] nehmekanten() {

	Dreistrecke[] strecken = new Dreistrecke[8];

	Dreivektor[] ecken = this.nehmeecken();

	int[][] streckenzeichen = new int[][] {{0,1},{1,2},{2,3},{3,0},
					       {0,4},{1,4},{2,4},{3,4}};

	for (int i = 0; i < streckenzeichen.length; i++) {
	    strecken[i] = new Dreistrecke(Vektorverdoppler.verdoppele(ecken[streckenzeichen[i][0]]),
					  Vektorverdoppler.verdoppele(ecken[streckenzeichen[i][1]])); 
	}

	// Wir sollen die Vektore verdoppeln, sodaß die Zeiger der
	// Strecken nicht voneinander abhängig sind. Das ist viel
	// einfacher in einem Programm.

	return strecken;
    }
}
