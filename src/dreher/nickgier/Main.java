package dreher.nickgier;

import vektor.Zweivektor;
import vektor.Dreivektor;
import matrix.Dreimatrix;
import druck.vektor.Vektordrucker;
import druck.matrix.Matrixdrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.nickgier.Main
*/

public class Main {
    static void beispielEins() {
	Dreivektor va = new Dreivektor(1,1,1);
	double thetagier = Nickgier.nehmegierwinkel(va);
	double thetanick = Nickgier.nehmenickwinkel(va);

	System.out.println("Gier [rad]: " + thetagier);
	System.out.println("Nick [rad]: " + thetanick);
    }

    public static void main(String[] args) {
	beispielEins();
    }
}
