package kante;

import punkt.Dreipunkt;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes kante.Main
*/

public class Main {

    static void beispielEins() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreikante ka = new Dreikante(pa, pb);

	System.out.println(ka.drucken());
    }

    static void beispielZwei() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreikante ka = new Dreikante(pa, pb);

	System.out.println(ka.drucken());

	ka.addieren(new Dreipunkt(5,5,5));

	System.out.println(ka.drucken());    
    }

    public static void main(String[] args) {
	beispielZwei();
    }
}
