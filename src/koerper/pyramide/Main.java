package koerper.pyramide;

import strecke.Dreistrecke;
import punkt.Dreipunkt;
import druck.punkt.Punktdrucker;
import druck.strecke.Streckedrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes koerper.pyramide.Main
*/

public class Main {
    public static void main(String[] args) {
	Pyramide p = new Pyramide(5,5);

	// Ecken
	Dreipunkt[] pl = p.nehmeecken();
	
	// Kanten
	Dreistrecke[] kl = p.nehmeStrecken();

	for (int i = 0; i < pl.length; i++) {
	    System.out.println(Punktdrucker.drucken(pl[i]));
	}

	for (int i = 0; i < kl.length; i++) {
	    System.out.println(Streckedrucker.drucken(kl[i]));
	}
    }
}
