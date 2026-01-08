package verdoppler.strecke;

import strecke.Zweistrecke;
import punkt.Zweipunkt;
import verdoppler.punkt.Punktverdoppler;

public class Streckeverdoppler {
    public static Zweistrecke verdoppeln(Zweistrecke k) {
	Zweipunkt vonNeu = Punktverdoppler.verdoppeln(k.von);
	Zweipunkt bisNeu = Punktverdoppler.verdoppeln(k.bis);
	
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
