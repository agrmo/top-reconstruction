package stellung.vielflach;

import vielflach.Vielflach;
import orientierung.Orientierung;
import stellung.Dreistellung;
import vektor.Dreivektor;
import vielflach.kubus.Kubus;
import druck.strecke.Streckedrucker;
import strecke.Dreistrecke;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes stellung.vielflach.Main
*/

public class Main {
    static void beispieleins() {
	Kubus k = new Kubus(3);
	Dreivektor ort = new Dreivektor(10,10,10);
	Orientierung orientierung = new Orientierung(0,Math.PI / 2.0,0);
	Dreistellung s = new Dreistellung(ort, orientierung);

	Dreistrecke[] strecken = Vielflachstellung.stelle(k, s);

	for (int i = 0; i < strecken.length; i++) {
	    System.out.println(Streckedrucker.drucke(strecken[i]));
	}
    }

    static void beispielzwei() {
    }

    static void beispieldrei() {
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
