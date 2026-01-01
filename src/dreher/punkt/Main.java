package dreher.punkt;

import punkt.Zweipunkt;
import punkt.Dreipunkt;
import druck.punkt.Punktdrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.punkt.Main
*/

public class Main {
    static void beispielEins() {
	// Gegen den Uhrzeigersinn.
	Zweipunkt pa = new Zweipunkt(1,0);
	Zweipunkt pb = Punktdreher.drehen(pa, Math.PI / 2.0);

	System.out.println(Punktdrucker.drucken(pa));
	System.out.println(Punktdrucker.drucken(pb));
    }

    static void beispielZwei() {
	// Gegen den Uhrzeigersinn.
	Zweipunkt pa = new Zweipunkt(1,1);
	Zweipunkt pb = Punktdreher.drehen(pa, Math.PI / 2.0);

	System.out.println(Punktdrucker.drucken(pa));
	System.out.println(Punktdrucker.drucken(pb));
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
