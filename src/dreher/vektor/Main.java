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

	System.out.println(Vektordrucker.drucken(pa));
	System.out.println(Vektordrucker.drucken(pb));
    }

    static void beispielZwei() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = Vektordreher.drehen(pa, Math.PI / 2.0);

	System.out.println(Vektordrucker.drucken(pa));
	System.out.println(Vektordrucker.drucken(pb));
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
