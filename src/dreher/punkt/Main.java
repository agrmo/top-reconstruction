package dreher.punkt;

import dreher.zweimatrix.Zweimatrixdreher;
import druck.matrix.Matrixdrucker;
import druck.vektor.Vektordrucker;
import matrix.Dreimatrix;
import matrix.Zweimatrix;
import vektor.Dreivektor;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.punkt.Main
*/

public class Main {
    static void beispieleins() {

	// Dreh [50,50] pi/2 um Null.
	Zweivektor va = new Zweivektor(50,50);
	Zweivektor drehpunkt = new Zweivektor(0,0);
	double theta = Math.PI / 2.0;
	Zweimatrix drehung = Zweimatrixdreher.nehmedrehung(theta);

	Zweivektor vb = Punktdreher.drehe(va, drehpunkt, drehung);
	System.out.println(Vektordrucker.drucke(vb));
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
