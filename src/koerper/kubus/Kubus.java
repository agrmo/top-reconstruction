package koerper.kubus;

import koerper.Koerper;
import vektor.Vektor;
import punkt.Punkt;
import kante.Kante;

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
    // aus: Liste von Punkten.
    // 
    // Nehme die Punkten, die die Ecken dieses Körpers beleuchten.
    public Punkt[] nehmeEcken() {
	Punkt[] punkten = new Punkt[8];
	int l = this.laenge;

	punkten[0] = new Punkt(0,0,0);
	punkten[1] = new Punkt(l,0,0);
	punkten[2] = new Punkt(l,0,l);
	punkten[3] = new Punkt(0,0,l);
	punkten[4] = new Punkt(0,l,0);
	punkten[5] = new Punkt(l,l,0);
	punkten[6] = new Punkt(l,l,l);
	punkten[7] = new Punkt(0,l,l);

	return punkten;
    }

    // ein:
    // aus: Liste von Kanten
    //
    // Nehme die die die Kanten dieses Körpers beleuchten.
    public Kante[] nehmeKanten() {
	Kante[] kanten = new Kante[12];

	Punkt[] punkten = this.nehmeEcken();

	kanten[0] = new Kante(punkten[0], punkten[1]);
	kanten[1] = new Kante(punkten[1], punkten[2]);
	kanten[2] = new Kante(punkten[2], punkten[3]);
	kanten[3] = new Kante(punkten[3], punkten[0]);
	kanten[4] = new Kante(punkten[4], punkten[5]);
	kanten[5] = new Kante(punkten[5], punkten[6]);
	kanten[6] = new Kante(punkten[6], punkten[7]);
	kanten[7] = new Kante(punkten[7], punkten[4]);
	kanten[8] = new Kante(punkten[0], punkten[4]);
	kanten[9] = new Kante(punkten[1], punkten[5]);
	kanten[10] = new Kante(punkten[2], punkten[6]);
	kanten[11] = new Kante(punkten[3], punkten[7]);
	
	return kanten;
    }
}
