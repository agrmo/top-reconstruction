package dreher.vektor;

import vektor.Zweivektor;
import vektor.Dreivektor;
import druck.vektor.Vektordrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.vektor.Main
*/

public class Main {
    static void beispielEins() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,0);
	Zweivektor pb = Vektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [0,1] sein.
	System.out.println(Vektordrucker.drucken(pb));
    }

    static void beispielZwei() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = Vektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [-1,1] sein.
	System.out.println(Vektordrucker.drucken(pb));
    }

    static void beispielDrei() {
	Dreivektor pa = new Dreivektor(1,1,1);
	
	Dreivektor pb = Vektordreher.drehenY(pa, Math.PI);

	// Soll [-1,1,-1] sein
	System.out.println(Vektordrucker.drucken(pb));	
    }

    static void beispielVier() {
	Dreivektor pa = new Dreivektor(1,1,1);
	
	Dreivektor pb = Vektordreher.drehenY(pa, Math.PI);
	Dreivektor pc = Vektordreher.drehenX(pb, Math.PI);

	// Soll [-1,-1,1] sein
	System.out.println(Vektordrucker.drucken(pc));
    }
    
    public static void main(String[] args) {
	beispielVier();
    }
}
