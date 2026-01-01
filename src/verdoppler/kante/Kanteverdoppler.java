package verdoppler.kante;

import java.util.ArrayList;
import kante.Zweikante;
import punkt.Zweipunkt;
import verdoppler.punkt.Punktverdoppler;

public class Kanteverdoppler {
    public static Zweikante verdoppeln(Zweikante k) {
	Zweipunkt vonNeu = Punktverdoppler.verdoppeln(k.von);
	Zweipunkt bisNeu = Punktverdoppler.verdoppeln(k.bis);
	
	return new Zweikante(vonNeu, bisNeu);
    }

    public static ArrayList<Zweikante> verdoppeln(ArrayList<Zweikante> kl) {

	ArrayList<Zweikante> klNeu = new ArrayList<Zweikante>();
	
	for (int i = 0; i < kl.size(); i++) {
	    klNeu.add(Kanteverdoppler.verdoppeln(kl.get(i)));
	}

	return klNeu;
    }
}
