package matrix;

import druck.matrix.Matrixdrucker;
import druck.vektor.Vektordrucker;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes matrix.Main
*/

public class Main {
    static void beispielEins() {
	Dreimatrix m = new Dreimatrix(1,2,3,4,5,6,7,8,9);

	// Soll [[1,2,3],[4,5,6],[7,8,9]] sein.
	System.out.println(Matrixdrucker.drucken(m));
    }

    static void beispielZwei() {
	Dreimatrix m = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreivektor v = new Dreivektor(1,1,1);

	// Soll [1,1,1] sein.
	System.out.println(Vektordrucker.drucken(m.punkt(v)));
    }

    static void beispielDrei() {
	Dreimatrix ma = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreimatrix mb = new Dreimatrix(1,0,0,0,1,0,0,0,1);

	// Soll [[1,0,0],[0,1,0],[0,0,1]] sein.
	System.out.println(Matrixdrucker.drucken(ma.punkt(mb)));
    }

    static void beispielVier() {
	Dreimatrix ma = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreimatrix mb = new Dreimatrix(0,0,1,0,1,0,1,0,0);

	// Soll [[0,0,1],[0,1,0],[1,0,0]] sein.
	System.out.println(Matrixdrucker.drucken(ma.punkt(mb)));
    }

    static void beispielFuenf() {
	Dreimatrix m = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreivektor v = new Dreivektor(4,4,4);

	System.out.println(Vektordrucker.drucken(m.punkt(v)));
    }

    static void beispielSechs() {
	Dreimatrix ma = new Dreimatrix(1,2,3,4,5,6,7,8,9);
	Dreimatrix mb = new Dreimatrix(3,2,1,6,5,4,9,8,7);
	Dreimatrix mc = ma.punkt(mb);
	System.out.println(Matrixdrucker.drucken(mc));

	/*
         |42.0 36.0 30.0|
         |96.0 81.0 66.0|
         |150.0 126.0 102.0|
	*/
    }

    public static void main(String[] args) {
	beispielSechs();
    }
}
