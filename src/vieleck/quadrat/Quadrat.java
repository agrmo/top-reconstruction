package vieleck.quadrat;

import vieleck.Vieleck;
import strecke.Zweistrecke;
import vektor.Zweivektor;

// Der Quadrat;
public class Quadrat extends Vieleck {
    public int laenge;
    
    public Quadrat(int l) {
	laenge = l;
    }

    public int nehmeeckenanzahl() {
	return 4;
    }
    
    public int nehmekantenanzahl() {
	return 4;
    }
    
    public Zweivektor[] nehmeecken() {
	Zweivektor[] ecken = new Zweivektor[4];

	int l = this.laenge;

	ecken[0] = new Zweivektor(0,0);
	ecken[1] = new Zweivektor(l,0);
	ecken[2] = new Zweivektor(l,l);
	ecken[3] = new Zweivektor(0,this.laenge);

	return ecken;
    }

    public Zweistrecke[] nehmekanten() {
	
	Zweistrecke[] strecken = new Zweistrecke[4];

	int l = this.laenge;

	strecken[0] = new Zweistrecke(new Zweivektor(0,0),new Zweivektor(l,0));
	strecken[1] = new Zweistrecke(new Zweivektor(l,0),new Zweivektor(l,l));
	strecken[2] = new Zweistrecke(new Zweivektor(l,l),new Zweivektor(0,l));
	strecken[1] = new Zweistrecke(new Zweivektor(0,l),new Zweivektor(0,0));

	return strecken;
    }
}
