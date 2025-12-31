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
	int l = this.laenge;

	// Wichtig: Wir können einfach this.nehmeEcken() nehmen, und
	// dessen Kennzeichen benutzen, aber das macht ein Pointer zum
	// gleichen Punkt. Das ist innerhalb einer Schleife
	// gefährlich, weil wir dreimal auf dem gleichen Punkte
	// durchlaufen würden!
	
	kanten[0] = new Dreikante(new Dreipunkt(0,0,0), new Dreipunkt(l,0,0));
	kanten[1] = new Dreikante(new Dreipunkt(l,0,0), new Dreipunkt(l,0,l));
	kanten[2] = new Dreikante(new Dreipunkt(l,0,l), new Dreipunkt(0,0,l));
	kanten[3] = new Dreikante(new Dreipunkt(0,0,l), new Dreipunkt(0,0,0));
	kanten[4] = new Dreikante(new Dreipunkt(0,l,0), new Dreipunkt(l,l,0));
	kanten[5] = new Dreikante(new Dreipunkt(l,l,0), new Dreipunkt(l,l,l));
	kanten[6] = new Dreikante(new Dreipunkt(l,l,l), new Dreipunkt(0,l,l));
	kanten[7] = new Dreikante(new Dreipunkt(0,l,l), new Dreipunkt(0,l,0));
	kanten[8] = new Dreikante(new Dreipunkt(0,0,0), new Dreipunkt(0,l,0));
	kanten[9] = new Dreikante(new Dreipunkt(l,0,0), new Dreipunkt(l,l,0));
	kanten[10] = new Dreikante(new Dreipunkt(l,0,l), new Dreipunkt(l,l,l));
	kanten[11] = new Dreikante(new Dreipunkt(0,0,l), new Dreipunkt(0,l,l));
	
	return kanten;
    }
}
