package strecke;

import vektor.Dreivektor;
import vektor.Zweivektor;
import druck.strecke.Streckedrucker;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes strecke.Main
*/

public class Main {

    static void beispielEins() {
	Dreivektor pa = new Dreivektor(1,1,1);
	Dreivektor pb = new Dreivektor(2,2,2);
	Dreistrecke ka = new Dreistrecke(pa, pb);

	System.out.println(Streckedrucker.drucken(ka));
    }

    static void beispielZwei() {
	Dreivektor pa = new Dreivektor(1,1,1);
	Dreivektor pb = new Dreivektor(2,2,2);
	Dreistrecke ka = new Dreistrecke(pa, pb);

	System.out.println(Streckedrucker.drucken(ka));

	ka.addiere(new Dreivektor(5,5,5));

	System.out.println(Streckedrucker.drucken(ka));    
    }
    
    static void beispielDrei() {
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = new Zweivektor(2,2);
	Zweistrecke ka = new Zweistrecke(pa, pb);
	System.out.println(Streckedrucker.drucken(ka));
	ka.addiere(new Zweivektor(5,5));
	System.out.println(Streckedrucker.drucken(ka));
    }

    public static void main(String[] args) {
	beispielDrei();
    }
}
