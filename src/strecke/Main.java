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
	Dreistrecke ds = new Dreistrecke(pa, pb);

	System.out.println(Streckedrucker.drucken(ds));
    }

    static void beispielZwei() {
	Dreivektor pa = new Dreivektor(1,1,1);
	Dreivektor pb = new Dreivektor(2,2,2);
	Dreistrecke ds = new Dreistrecke(pa, pb);
	System.out.println(Streckedrucker.drucken(ds));
	ds.addiere(new Dreivektor(5,5,5));
	System.out.println(Streckedrucker.drucken(ds));    
    }
    
    static void beispielDrei() {
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = new Zweivektor(2,2);
	Zweistrecke zs = new Zweistrecke(pa, pb);
	System.out.println(Streckedrucker.drucken(zs));
	zs.addiere(new Zweivektor(5,5));
	System.out.println(Streckedrucker.drucken(zs));
    }

    public static void main(String[] args) {
	beispielDrei();
    }
}
