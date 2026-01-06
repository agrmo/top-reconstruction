package strecke;

import punkt.Dreipunkt;
import punkt.Zweipunkt;
import druck.strecke.Streckedrucker;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes strecke.Main
*/

public class Main {

    static void beispielEins() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreistrecke ka = new Dreistrecke(pa, pb);

	System.out.println(Streckedrucker.drucken(ka));
    }

    static void beispielZwei() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreistrecke ka = new Dreistrecke(pa, pb);

	System.out.println(Streckedrucker.drucken(ka));

	ka.addieren(new Dreipunkt(5,5,5));

	System.out.println(Streckedrucker.drucken(ka));    
    }
    
    static void beispielDrei() {
	Zweipunkt pa = new Zweipunkt(1,1);
	Zweipunkt pb = new Zweipunkt(2,2);
	Zweistrecke ka = new Zweistrecke(pa, pb);
	System.out.println(Streckedrucker.drucken(ka));
	ka.addieren(new Zweipunkt(5,5));
	System.out.println(Streckedrucker.drucken(ka));
    }

    public static void main(String[] args) {
	beispielDrei();
    }
}
