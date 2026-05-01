package verdoppler.strecke;

import strecke.Zweistrecke;
import vektor.Zweivektor;
import verdoppler.vektor.Vektorverdoppler;

public class Streckeverdoppler {
    public static Zweistrecke verdoppele(Zweistrecke k) {
	Zweivektor vonNeu = Vektorverdoppler.verdoppele(k.von);
	Zweivektor bisNeu = Vektorverdoppler.verdoppele(k.bis);
	
	return new Zweistrecke(vonNeu, bisNeu);
    }

    public static Zweistrecke[] verdoppele(Zweistrecke[] kl) {

	Zweistrecke[] klNeu = new Zweistrecke[kl.length];
	
	for (int i = 0; i < kl.length; i++) {
	    klNeu[i] = Streckeverdoppler.verdoppele(kl[i]);
	}

	return klNeu;
    }
}
