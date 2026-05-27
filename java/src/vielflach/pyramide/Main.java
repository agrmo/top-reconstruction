package vielflach.pyramide;

import strecke.Dreistrecke;
import vektor.Dreivektor;
import druck.vektor.Vektordrucker;
import druck.strecke.Streckedrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes vielflach.pyramide.Main
*/

public class Main {
    public static void main(String[] args) {
	Pyramide p = new Pyramide(5,5);

	// Ecken
	Dreivektor[] pl = p.nehmeecken();
	
	// Kanten
	Dreistrecke[] kl = p.nehmekanten();

	for (int i = 0; i < pl.length; i++) {
	    System.out.println(Vektordrucker.drucke(pl[i]));
	}

	for (int i = 0; i < kl.length; i++) {
	    System.out.println(Streckedrucker.drucke(kl[i]));
	}
    }
}
