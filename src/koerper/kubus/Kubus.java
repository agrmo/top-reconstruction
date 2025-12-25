package koerper.kubus;

import koerper.Koerper;
import vektor.Vektor;
import punkt.Punkt;

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
    // Nehme die Punkten, die die Ecken dieses Körpers bestimmen.
    public Punkt[] nehmeEcken() {
	Punkt[] punkten = new Punkt[8];
	int l = this.laenge;

	punkten[0] = new Punkt(new int[] {0,0,0});
	punkten[1] = new Punkt(new int[] {l,0,0});
	punkten[2] = new Punkt(new int[] {0,l,0});
	punkten[3] = new Punkt(new int[] {0,0,l});
	punkten[4] = new Punkt(new int[] {l,l,0});
	punkten[5] = new Punkt(new int[] {0,l,l});
	punkten[6] = new Punkt(new int[] {l,0,l});
	punkten[7] = new Punkt(new int[] {l,l,l});

	return punkten;
    }
}
