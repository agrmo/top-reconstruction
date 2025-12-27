package kante;

import punkt.Punkt;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes kante.Main
*/

public class Main {

    static void beispielEins() {
	Punkt pa = new Punkt(1,1,1);
	Punkt pb = new Punkt(2,2,2);
	Kante ka = new Kante(pa, pb);

	System.out.println(ka.drucken());
    }

    static void beispielZwei() {
	Punkt pa = new Punkt(1,1,1);
	Punkt pb = new Punkt(2,2,2);
	Kante ka = new Kante(pa, pb);

	System.out.println(ka.drucken());

	ka.addieren(new Punkt(5,5,5));

	System.out.println(ka.drucken());    
    }

    public static void main(String[] args) {
	beispielZwei();
    }
}
