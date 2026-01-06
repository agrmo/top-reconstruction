package verdoppler.strecke;

import punkt.Zweipunkt;
import druck.strecke.Streckedrucker;
import strecke.Zweistrecke;
import java.util.ArrayList;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes verdoppler.strecke.Main
*/

public class Main {
    public static void main(String[] args) {

	ArrayList<Zweistrecke> kl = new ArrayList<Zweistrecke>();
	kl.add(new Zweistrecke(new Zweipunkt(1,1), new Zweipunkt(2,2)));
	kl.add(new Zweistrecke(new Zweipunkt(1,2), new Zweipunkt(2,3)));

	ArrayList<Zweistrecke> klNeu = Streckeverdoppler.verdoppeln(kl);
	
	kl.get(1).addieren(new Zweipunkt(5,5));

	for (int i = 0; i < kl.size(); i++) {
	    System.out.println(Streckedrucker.drucken(kl.get(i)));
	}

	for (int i = 0; i < kl.size(); i++) {
	    System.out.println(Streckedrucker.drucken(klNeu.get(i)));
	}
    }
}
