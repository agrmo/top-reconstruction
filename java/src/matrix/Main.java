package matrix;

import druck.matrix.Matrixdrucker;
import druck.vektor.Vektordrucker;
import vektor.Dreivektor;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes matrix.Main
*/

public class Main {
    static void beispieleins() {
	Dreimatrix m = new Dreimatrix(1,2,3,4,5,6,7,8,9);

	// Soll [[1,2,3],[4,5,6],[7,8,9]] sein.
	System.out.println(Matrixdrucker.drucke(m));
    }

    static void beispielzwei() {
	Dreimatrix m = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreivektor v = new Dreivektor(1,1,1);

	// Soll [1,1,1] sein.
	System.out.println(Vektordrucker.drucke(m.punkt(v)));
    }

    static void beispieldrei() {
	Dreimatrix ma = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreimatrix mb = new Dreimatrix(1,0,0,0,1,0,0,0,1);

	// Soll [[1,0,0],[0,1,0],[0,0,1]] sein.
	System.out.println(Matrixdrucker.drucke(ma.punkt(mb)));
    }

    static void beispielvier() {
	Dreimatrix ma = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreimatrix mb = new Dreimatrix(0,0,1,0,1,0,1,0,0);

	// Soll [[0,0,1],[0,1,0],[1,0,0]] sein.
	System.out.println(Matrixdrucker.drucke(ma.punkt(mb)));
    }

    static void beispielfuenf() {
	Dreimatrix m = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreivektor v = new Dreivektor(4,4,4);

	System.out.println(Vektordrucker.drucke(m.punkt(v)));
    }

    static void beispielsechs() {
	Zweimatrix m = new Zweimatrix(1,2,3,4);
	Zweivektor v = new Zweivektor(5,6);
	System.out.println(Vektordrucker.drucke(m.punkt(v)));

	/*
	  |17|
	  |39|
	 */
    }

    static void beispielsieben() {
	Zweimatrix ma = new Zweimatrix(1,2,3,4);
	Zweimatrix mb = new Zweimatrix(5,6,7,8);
	Zweimatrix mc = ma.punkt(mb);
	System.out.println(Matrixdrucker.drucke(mc));

	/*
	  |19 22|
	  |43 50|
	*/	
    }

    static void beispielacht() {
	Dreimatrix ma = new Dreimatrix(1,2,3,4,5,6,7,8,9);
	Dreimatrix mb = new Dreimatrix(3,2,1,6,5,4,9,8,7);
	Dreimatrix mc = ma.punkt(mb);
	System.out.println(Matrixdrucker.drucke(mc));

	/*
	  |42 36 30|
	  |96 81 66|
	  |150 126 102|
	*/	
    }

    public static void main(String[] args) {
	beispielsechs();
    }
}
