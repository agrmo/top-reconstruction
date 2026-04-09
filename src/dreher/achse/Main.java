package dreher.achse;

import dreher.vektor.Vektordreher;
import druck.vektor.Vektordrucker;
import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.achse.Main
*/

public class Main {
    static void beispielEins() {
	Dreivektor va = new Dreivektor(50,50,50);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);

	System.out.println(Matrixdrucker.drucke(ma));

	Dreivektor vb = ma.punkt(va);
	System.out.println(Vektordrucker.drucke(vb));
	
	// [86,0,0]
    }

    static void beispielZwei() {
	Dreivektor va = new Dreivektor(30,-10,20);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);

	System.out.println(Matrixdrucker.drucke(ma));

	Dreivektor vb = ma.punkt(va);
	System.out.println(Vektordrucker.drucke(vb));
	
	// [37,0,0]
    }

    static void beispielDrei() {
	Dreivektor va = new Dreivektor(-30,-10,-20);
	Dreimatrix ma = Achsedreher.nehmexachsedrehung(va);

	System.out.println(Matrixdrucker.drucke(ma));

	Dreivektor vb = ma.punkt(va);
	System.out.println(Vektordrucker.drucke(vb));
	
	// [-37,0,0] ?
    }

    public static void main(String[] args) {
	beispielZwei();
    }
}
