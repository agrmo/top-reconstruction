package koerper.kubus;

import koerper.Koerper;
import vektor.Dreivektor;
import punkt.Dreipunkt;
import kante.Dreikante;

// Der Kubus. Wir müssen nicht bestimmen, woran dieser Kubus
// liegt. Wir brauchen auch nicht zu bestimmen, was die
// Ausbreitungsrichtung dieses Kubus ist. Er ist nur ein Kubus. Wie er
// aussieht wird von anderen Sachen gezeigt.
public class Kubus extends Koerper {

    // Seine Länge.
    public int laenge;
    
    public Kubus(int l) {
	this.laenge = l;
    }

    // ein:
    // aus: Liste von Dreipunkten.
    // 
    // Nehme die Dreipunkten, die die Ecken dieses Körpers beleuchten.
    public Dreipunkt[] nehmeEcken() {
	Dreipunkt[] punkten = new Dreipunkt[8];
	int l = this.laenge;

	punkten[0] = new Dreipunkt(0,0,0);
	punkten[1] = new Dreipunkt(l,0,0);
	punkten[2] = new Dreipunkt(l,0,l);
	punkten[3] = new Dreipunkt(0,0,l);
	punkten[4] = new Dreipunkt(0,l,0);
	punkten[5] = new Dreipunkt(l,l,0);
	punkten[6] = new Dreipunkt(l,l,l);
	punkten[7] = new Dreipunkt(0,l,l);

	return punkten;
    }

    // ein:
    // aus: Liste von Dreikanten
    //
    // Nehme die die die Dreikanten dieses Körpers beleuchten. Wir
    // speichern die Werte der Dreikanten gar nicht! 
    public Dreikante[] nehmeKanten() {
	Dreikante[] kanten = new Dreikante[12];

	Dreipunkt[] punkten = this.nehmeEcken();

	kanten[0] = new Dreikante(punkten[0], punkten[1]);
	kanten[1] = new Dreikante(punkten[1], punkten[2]);
	kanten[2] = new Dreikante(punkten[2], punkten[3]);
	kanten[3] = new Dreikante(punkten[3], punkten[0]);
	kanten[4] = new Dreikante(punkten[4], punkten[5]);
	kanten[5] = new Dreikante(punkten[5], punkten[6]);
	kanten[6] = new Dreikante(punkten[6], punkten[7]);
	kanten[7] = new Dreikante(punkten[7], punkten[4]);
	kanten[8] = new Dreikante(punkten[0], punkten[4]);
	kanten[9] = new Dreikante(punkten[1], punkten[5]);
	kanten[10] = new Dreikante(punkten[2], punkten[6]);
	kanten[11] = new Dreikante(punkten[3], punkten[7]);
	
	return kanten;
    }
}
