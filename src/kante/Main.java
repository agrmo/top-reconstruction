package kante;

import punkt.Dreipunkt;
import punkt.Zweipunkt;
import druck.kante.Kantedrucker;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes kante.Main
*/

public class Main {

    static void beispielEins() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreikante ka = new Dreikante(pa, pb);

	System.out.println(Kantedrucker.drucken(ka));
    }

    static void beispielZwei() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreikante ka = new Dreikante(pa, pb);

	System.out.println(Kantedrucker.drucken(ka));

	ka.addieren(new Dreipunkt(5,5,5));

	System.out.println(Kantedrucker.drucken(ka));    
    }
    
    static void beispielDrei() {
	Zweipunkt pa = new Zweipunkt(1,1);
	Zweipunkt pb = new Zweipunkt(2,2);
	Zweikante ka = new Zweikante(pa, pb);
	System.out.println(Kantedrucker.drucken(ka));
	ka.addieren(new Zweipunkt(5,5));
	System.out.println(Kantedrucker.drucken(ka));
    }

    public static void main(String[] args) {
	beispielDrei();
    }
}
