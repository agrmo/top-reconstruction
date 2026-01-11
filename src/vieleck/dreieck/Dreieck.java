package vieleck.dreieck;

import strecke.Zweistrecke;
import vektor.Zweivektor;
import verdoppler.vektor.Vektorverdoppler;
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

    public Zweivektor[] nehmeecken() {
	Zweivektor[] ecken = new Zweivektor[3];

	ecken[0] = new Zweivektor(0,0);
	ecken[1] = new Zweivektor(this.laenge,0);
	ecken[2] = new Zweivektor(this.laenge / 2.0, (Math.sqrt(3) * this.laenge) / 2.0);

	return ecken;
    }

    public Zweistrecke[] nehmekanten() {

	Zweivektor[] ecken = this.nehmeecken();

	Zweistrecke[] strecken = new Zweistrecke[3];

	strecken[0] = new Zweistrecke(Vektorverdoppler.verdoppeln(ecken[0]),
				      Vektorverdoppler.verdoppeln(ecken[1]));

	strecken[1] = new Zweistrecke(Vektorverdoppler.verdoppeln(ecken[1]),
				      Vektorverdoppler.verdoppeln(ecken[2]));

	strecken[2] = new Zweistrecke(Vektorverdoppler.verdoppeln(ecken[2]),
				      Vektorverdoppler.verdoppeln(ecken[0]));

	return strecken;
    }
}
