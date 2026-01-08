package verdoppler.strecke;

import punkt.Zweipunkt;
import druck.strecke.Streckedrucker;
import strecke.Zweistrecke;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes verdoppler.strecke.Main
*/

public class Main {
    public static void main(String[] args) {

	Zweistrecke[] kl = new Zweistrecke[] {
	    new Zweistrecke(new Zweipunkt(1,1), new Zweipunkt(2,2)),
	    new Zweistrecke(new Zweipunkt(1,2), new Zweipunkt(2,3))
	};

	Zweistrecke[] klNeu = Streckeverdoppler.verdoppeln(kl);
	
	kl[1].addieren(new Zweipunkt(5,5));

	for (int i = 0; i < kl.length; i++) {
	    System.out.println(Streckedrucker.drucken(kl[i]));
	}

	for (int i = 0; i < kl.length; i++) {
	    System.out.println(Streckedrucker.drucken(klNeu[i]));
	}
    }
}
