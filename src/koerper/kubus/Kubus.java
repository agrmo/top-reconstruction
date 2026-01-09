package koerper.kubus;

import koerper.Koerper;
import punkt.Dreipunkt;
import strecke.Dreistrecke;
import verdoppler.punkt.Punktverdoppler;

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
    public Dreipunkt[] nehmeecken() {
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

    public int nehmestreckenanzahl() {
	return 12;
    }

    // ein:
    // aus: Liste von Dreistrecken
    //
    // Nehme die die die Dreistrecken dieses Körpers beleuchten. Wir
    // speichern die Werte der Dreistrecken gar nicht! 
    public Dreistrecke[] nehmeStrecken() {
	Dreistrecke[] strecken = new Dreistrecke[12];

	Dreipunkt[] ecken = this.nehmeecken();

	int[][] streckenzeichen = new int[][] {{0,1},{1,2},{2,3},{3,0},
					       {4,5},{5,6},{6,7},{7,4},
					       {0,4},{1,5},{2,6},{3,7}};

	for (int i = 0; i < streckenzeichen.length; i++) {
	    strecken[i] = new Dreistrecke(Punktverdoppler.verdoppeln(ecken[streckenzeichen[i][0]]),
					  Punktverdoppler.verdoppeln(ecken[streckenzeichen[i][1]])); 
	}

	// Wir sollen die Punkte verdoppeln, sodaß die Zeiger der
	// Strecken nicht voneinander abhängig sind. Das ist viel
	// einfacher in einem Programm.
	
	return strecken;
    }
}
