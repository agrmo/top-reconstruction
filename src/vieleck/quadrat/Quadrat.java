package vieleck.quadrat;

import vieleck.Vieleck;
import strecke.Zweistrecke;
import punkt.Zweipunkt;

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
    
    public Zweipunkt[] nehmeecken() {
	Zweipunkt[] ecken = new Zweipunkt[4];

	int l = this.laenge;

	ecken[0] = new Zweipunkt(0,0);
	ecken[1] = new Zweipunkt(l,0);
	ecken[2] = new Zweipunkt(l,l);
	ecken[3] = new Zweipunkt(0,this.laenge);

	return ecken;
    }

    public Zweistrecke[] nehmekanten() {
	
	Zweistrecke[] strecken = new Zweistrecke[4];

	int l = this.laenge;

	strecken[0] = new Zweistrecke(new Zweipunkt(0,0),new Zweipunkt(l,0));
	strecken[1] = new Zweistrecke(new Zweipunkt(l,0),new Zweipunkt(l,l));
	strecken[2] = new Zweistrecke(new Zweipunkt(l,l),new Zweipunkt(0,l));
	strecken[1] = new Zweistrecke(new Zweipunkt(0,l),new Zweipunkt(0,0));

	return strecken;
    }
}
