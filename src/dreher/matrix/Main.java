package dreher.matrix;

import vektor.Zweivektor;
import vektor.Dreivektor;
import matrix.Dreimatrix;
import druck.vektor.Vektordrucker;
import druck.matrix.Matrixdrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.matrix.Main
*/

public class Main {
    static void beispielEins() {
	Dreimatrix mx = Matrixdreher.nehmedreherx(Math.PI);
	Dreimatrix my = Matrixdreher.nehmedrehery(Math.PI);
	Dreimatrix mz = Matrixdreher.nehmedreherz(Math.PI);

	System.out.println(Matrixdrucker.drucken(mx));
	System.out.println(Matrixdrucker.drucken(my));
	System.out.println(Matrixdrucker.drucken(mz));
    }

    static void beispielZwei() {
	Dreimatrix mx = Matrixdreher.nehmedreherx(Math.PI);
	Dreimatrix my = Matrixdreher.nehmedrehery(Math.PI);
	Dreimatrix mz = Matrixdreher.nehmedreherz(Math.PI);
	
	Dreivektor v = new Dreivektor(1,0,0);

	// Man dreht einen x-Einheitsvektor.
	// 1. um die x-Achse: nichts getan.
	// 2. um die y-Achse: in der xz-Fläche.
	// 3. um die z-Achse: in der xy-Fläche.

	// Die Bahnen von 2 und 3 sind verschieden, aber die
	// endgültigen Vektoren sind gleich.

	// Soll 
	// [1,0,0]
	// [-1,0,0]
	// [-1,0,0]
	// geben.
	System.out.println(Vektordrucker.drucken(mx.punkt(v)));
	System.out.println(Vektordrucker.drucken(my.punkt(v)));
	System.out.println(Vektordrucker.drucken(mz.punkt(v)));
    }

    static void beispielDrei() {
    }

    static void beispielVier() {
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
