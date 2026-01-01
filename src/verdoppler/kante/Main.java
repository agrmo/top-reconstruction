package verdoppler.kante;

import punkt.Zweipunkt;
import druck.kante.Kantedrucker;
import kante.Zweikante;
import java.util.ArrayList;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes verdoppler.kante.Main
*/

public class Main {
    public static void main(String[] args) {

	ArrayList<Zweikante> kl = new ArrayList<Zweikante>();
	kl.add(new Zweikante(new Zweipunkt(1,1), new Zweipunkt(2,2)));
	kl.add(new Zweikante(new Zweipunkt(1,2), new Zweipunkt(2,3)));

	ArrayList<Zweikante> klNeu = Kanteverdoppler.verdoppeln(kl);
	
	kl.get(1).addieren(new Zweipunkt(5,5));

	for (int i = 0; i < kl.size(); i++) {
	    System.out.println(Kantedrucker.drucken(kl.get(i)));
	}

	for (int i = 0; i < kl.size(); i++) {
	    System.out.println(Kantedrucker.drucken(klNeu.get(i)));
	}
    }
}
