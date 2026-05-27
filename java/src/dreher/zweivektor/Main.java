package dreher.zweivektor;

import vektor.Zweivektor;
import druck.vektor.Vektordrucker;
import dreher.zweivektor.Zweivektordreher;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.zweivektor.Main
*/

public class Main {
    static void beispieleins() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,0);
	Zweivektor pb = Zweivektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [0,1] sein.
	System.out.println(Vektordrucker.drucke(pb));
    }

    static void beispielzwei() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = Zweivektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [-1,1] sein.
	System.out.println(Vektordrucker.drucke(pb));
    }
    
    public static void main(String[] args) {
	beispielzwei();
    }
}
