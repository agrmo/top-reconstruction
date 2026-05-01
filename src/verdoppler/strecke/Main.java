package verdoppler.strecke;

import vektor.Zweivektor;
import druck.strecke.Streckedrucker;
import strecke.Zweistrecke;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes verdoppler.strecke.Main
*/

public class Main {
    public static void main(String[] args) {

	Zweistrecke[] kl = new Zweistrecke[] {
	    new Zweistrecke(new Zweivektor(1,1), new Zweivektor(2,2)),
	    new Zweistrecke(new Zweivektor(1,2), new Zweivektor(2,3))
	};

	Zweistrecke[] klNeu = Streckeverdoppler.verdoppele(kl);
	
	kl[1].addiere(new Zweivektor(5,5));

	for (int i = 0; i < kl.length; i++) {
	    System.out.println(Streckedrucker.drucke(kl[i]));
	}

	for (int i = 0; i < kl.length; i++) {
	    System.out.println(Streckedrucker.drucke(klNeu[i]));
	}
    }
}
