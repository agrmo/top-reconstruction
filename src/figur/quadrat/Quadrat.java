package figur.quadrat;

import figur.Figur;
import kante.Zweikante;
import punkt.Zweipunkt;

// Der Quadrat;
public class Quadrat extends Figur {
    public int laenge;
    
    public Quadrat(int l) {
	laenge = l;
    }

    public Zweipunkt[] nehmeEcken() {
	Zweipunkt[] ecken = new Zweipunkt[4];

	int l = this.laenge;

	ecken[0] = new Zweipunkt(0,0);
	ecken[1] = new Zweipunkt(l,0);
	ecken[2] = new Zweipunkt(l,l);
	ecken[3] = new Zweipunkt(0,this.laenge);

	return ecken;
    }

    public Zweikante[] nehmeKanten() {
	
	Zweikante[] kanten = new Zweikante[4];

	int l = this.laenge;

	kanten[0] = new Zweikante(new Zweipunkt(0,0),new Zweipunkt(l,0));
	kanten[1] = new Zweikante(new Zweipunkt(l,0),new Zweipunkt(l,l));
	kanten[2] = new Zweikante(new Zweipunkt(l,l),new Zweipunkt(0,l));
	kanten[1] = new Zweikante(new Zweipunkt(0,l),new Zweipunkt(0,0));

	return kanten;
    }
}
