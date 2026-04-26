package vielflach.kubus;

import vielflach.Vielflach;
import vektor.Dreivektor;
import strecke.Dreistrecke;
import verdoppler.vektor.Vektorverdoppler;

// Der Kubus. Wir müssen nicht bestimmen, woran dieser Kubus
// liegt. Wir brauchen auch nicht zu bestimmen, was die
// Ausbreitungsrichtung dieses Kubus ist. Er ist nur ein Kubus. Wie er
// aussieht wird von anderen Sachen gezeigt.
public class Kubus extends Vielflach {

    // Seine Länge.
    public int laenge;
    
    public Kubus(int l) {
	this.laenge = l;
    }

    public int nehmeeckenanzahl() {
	return 8;
    }

    public int nehmekantenanzahl() {
	return 12;
    }	

    // ein:
    // aus: Liste von Dreivektoren.
    // 
    // Nehme die Dreivektoren, die die Ecken dieses Körpers beleuchten.
    public Dreivektor[] nehmeecken() {
	Dreivektor[] vektoren = new Dreivektor[8];
	int l = this.laenge;

	vektoren[0] = new Dreivektor(0,0,0);
	vektoren[1] = new Dreivektor(l,0,0);
	vektoren[2] = new Dreivektor(l,0,l);
	vektoren[3] = new Dreivektor(0,0,l);
	vektoren[4] = new Dreivektor(0,l,0);
	vektoren[5] = new Dreivektor(l,l,0);
	vektoren[6] = new Dreivektor(l,l,l);
	vektoren[7] = new Dreivektor(0,l,l);

	return vektoren;
    }

    // ein:
    // aus: Liste von Dreistrecken
    //
    // Nehme die die die Dreistrecken dieses Körpers beleuchten. Wir
    // speichern die Werte der Dreistrecken gar nicht.  Die ausgehende
    // Vektoren sind verdoppelt.
    public Dreistrecke[] nehmekanten() {
	Dreistrecke[] strecken = new Dreistrecke[12];

	Dreivektor[] ecken = this.nehmeecken();

	int[][] streckenzeichen = new int[][] {{0,1},{1,2},{2,3},{3,0},
					       {4,5},{5,6},{6,7},{7,4},
					       {0,4},{1,5},{2,6},{3,7}};

	for (int i = 0; i < streckenzeichen.length; i++) {
	    strecken[i] = new Dreistrecke(Vektorverdoppler.verdoppeln(ecken[streckenzeichen[i][0]]),
					  Vektorverdoppler.verdoppeln(ecken[streckenzeichen[i][1]])); 
	}

	return strecken;
    }
}
