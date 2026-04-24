package dreher.achse;

import druck.vektor.Vektordrucker;
import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.achse.Main
*/

public class Main {
    static void beispieleins() {
	Dreivektor va = new Dreivektor(50,50,50);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);

	System.out.println(Matrixdrucker.drucke(ma));

	Dreivektor vb = ma.punkt(va);
	System.out.println(Vektordrucker.drucke(vb));
	
	// [86,0,0]
    }

    static void beispielzwei() {
	Dreivektor va = new Dreivektor(30,-10,20);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);

	System.out.println(Matrixdrucker.drucke(ma));

	Dreivektor vb = ma.punkt(va);
	System.out.println(Vektordrucker.drucke(vb));
	
	// [37,0,0]
    }

    static void beispieldrei() {
	Dreivektor va = new Dreivektor(-30,-10,-20);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);

	System.out.println(Matrixdrucker.drucke(ma));

	Dreivektor vb = ma.punkt(va);
	System.out.println(Vektordrucker.drucke(vb));
	
	// [-37,0,0] ?
    }

    static void beispielvier() {

	// Gegeben einen Vektor [50,50,50],
	// 1. Drehe ihn zu der x-Achse
	// 2. Drehe ihn zurück zu [50,50,50].

	Dreivektor va = new Dreivektor(50,50,50);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);
	Dreimatrix mb = Achsedreher.nehmexachsedrehungumkehrung(va);
	Dreivektor vb = ma.punkt(va);
	Dreivektor vc = mb.punkt(vb);

	System.out.println(Vektordrucker.drucke(va));
	System.out.println(Vektordrucker.drucke(vb));
	System.out.println(Vektordrucker.drucke(vc));
    }

    public static void main(String[] args) {
	beispielvier();
    }
}
