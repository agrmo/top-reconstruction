package verdoppler.strecke;

import java.util.ArrayList;
import strecke.Zweistrecke;
import punkt.Zweipunkt;
import verdoppler.punkt.Punktverdoppler;

public class Streckeverdoppler {
    public static Zweistrecke verdoppeln(Zweistrecke k) {
	Zweipunkt vonNeu = Punktverdoppler.verdoppeln(k.von);
	Zweipunkt bisNeu = Punktverdoppler.verdoppeln(k.bis);
	
	return new Zweistrecke(vonNeu, bisNeu);
    }

    public static ArrayList<Zweistrecke> verdoppeln(ArrayList<Zweistrecke> kl) {

	ArrayList<Zweistrecke> klNeu = new ArrayList<Zweistrecke>();
	
	for (int i = 0; i < kl.size(); i++) {
	    klNeu.add(Streckeverdoppler.verdoppeln(kl.get(i)));
	}

	return klNeu;
    }
}
