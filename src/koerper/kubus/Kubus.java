package koerper.kubus;

import koerper.Koerper;
import punkt.Dreipunkt;
import strecke.Dreistrecke;

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
    // aus: Liste von Dreistrecken
    //
    // Nehme die die die Dreistrecken dieses Körpers beleuchten. Wir
    // speichern die Werte der Dreistrecken gar nicht! 
    public Dreistrecke[] nehmeStrecken() {
	Dreistrecke[] strecken = new Dreistrecke[12];
	int l = this.laenge;

	// Wichtig: Wir können einfach this.nehmeEcken() nehmen, und
	// dessen Kennzeichen benutzen, aber das macht ein Pointer zum
	// gleichen Punkt. Das ist innerhalb einer Schleife
	// gefährlich, weil wir dreimal auf dem gleichen Punkte
	// durchlaufen würden!
	
	strecken[0] = new Dreistrecke(new Dreipunkt(0,0,0), new Dreipunkt(l,0,0));
	strecken[1] = new Dreistrecke(new Dreipunkt(l,0,0), new Dreipunkt(l,0,l));
	strecken[2] = new Dreistrecke(new Dreipunkt(l,0,l), new Dreipunkt(0,0,l));
	strecken[3] = new Dreistrecke(new Dreipunkt(0,0,l), new Dreipunkt(0,0,0));
	strecken[4] = new Dreistrecke(new Dreipunkt(0,l,0), new Dreipunkt(l,l,0));
	strecken[5] = new Dreistrecke(new Dreipunkt(l,l,0), new Dreipunkt(l,l,l));
	strecken[6] = new Dreistrecke(new Dreipunkt(l,l,l), new Dreipunkt(0,l,l));
	strecken[7] = new Dreistrecke(new Dreipunkt(0,l,l), new Dreipunkt(0,l,0));
	strecken[8] = new Dreistrecke(new Dreipunkt(0,0,0), new Dreipunkt(0,l,0));
	strecken[9] = new Dreistrecke(new Dreipunkt(l,0,0), new Dreipunkt(l,l,0));
	strecken[10] = new Dreistrecke(new Dreipunkt(l,0,l), new Dreipunkt(l,l,l));
	strecken[11] = new Dreistrecke(new Dreipunkt(0,0,l), new Dreipunkt(0,l,l));
	
	return strecken;
    }
}
