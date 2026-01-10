package vieleck.dreieck;

import strecke.Zweistrecke;
import punkt.Zweipunkt;
import verdoppler.punkt.Punktverdoppler;
import vieleck.Vieleck;

// Das gleichseitiges Dreieck.
public class Dreieck extends Vieleck {

    public int laenge;

    // ein: int
    //
    // Die Läenge seiner Seite.
    public Dreieck(int l) {
	this.laenge = l;
    }

    public int nehmeeckenanzahl() {
	return 3;
    }
    
    public int nehmekantenanzahl() {
	return 3;
    }

    public Zweipunkt[] nehmeecken() {
	Zweipunkt[] ecken = new Zweipunkt[3];

	ecken[0] = new Zweipunkt(0,0);
	ecken[1] = new Zweipunkt(this.laenge,0);
	ecken[2] = new Zweipunkt(this.laenge / 2.0, (Math.sqrt(3) * this.laenge) / 2.0);

	return ecken;
    }

    public Zweistrecke[] nehmekanten() {

	Zweipunkt[] ecken = this.nehmeecken();

	Zweistrecke[] strecken = new Zweistrecke[3];

	strecken[0] = new Zweistrecke(Punktverdoppler.verdoppeln(ecken[0]),
				      Punktverdoppler.verdoppeln(ecken[1]));

	strecken[1] = new Zweistrecke(Punktverdoppler.verdoppeln(ecken[1]),
				      Punktverdoppler.verdoppeln(ecken[2]));

	strecken[2] = new Zweistrecke(Punktverdoppler.verdoppeln(ecken[2]),
				      Punktverdoppler.verdoppeln(ecken[0]));

	return strecken;
    }
}
