package verdoppler.strecke;

import strecke.Zweistrecke;
import vektor.Zweivektor;
import verdoppler.vektor.Vektorverdoppler;

public class Streckeverdoppler {
    public static Zweistrecke verdoppeln(Zweistrecke k) {
	Zweivektor vonNeu = Vektorverdoppler.verdoppeln(k.von);
	Zweivektor bisNeu = Vektorverdoppler.verdoppeln(k.bis);
	
	return new Zweistrecke(vonNeu, bisNeu);
    }

    public static Zweistrecke[] verdoppeln(Zweistrecke[] kl) {

	Zweistrecke[] klNeu = new Zweistrecke[kl.length];
	
	for (int i = 0; i < kl.length; i++) {
	    klNeu[i] = Streckeverdoppler.verdoppeln(kl[i]);
	}

	return klNeu;
    }
}
