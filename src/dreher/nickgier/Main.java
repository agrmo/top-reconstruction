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

    static void beispielZwei() {

	// Die zwei Vektoren [10,10,10] und [20,20,20] soll die
	// gleiche Gier- und Nickwinkel besitzen.
	Dreivektor va = new Dreivektor(30,30,30);
	Dreivektor vb = new Dreivektor(100,100,100);
	double thetagiera = Nickgier.nehmegierwinkel(va);
	double thetanicka = Nickgier.nehmenickwinkel(va);
	double thetagierb = Nickgier.nehmegierwinkel(vb);
	double thetanickb = Nickgier.nehmenickwinkel(vb);

	System.out.println("A Gier [rad]: " + thetagiera);
	System.out.println("A Nick [rad]: " + thetanicka);
	System.out.println("B Gier [rad]: " + thetagierb);
	System.out.println("B Nick [rad]: " + thetanickb);
    }

    static void beispielDrei() {
	// Man shaut sich dem Vektor [30,30,30] von Standpunkt [100,100,100] an.
	Dreivektor va = new Dreivektor(30,30,30);
	Dreivektor augevektor = new Dreivektor(100,100,100);
	
    }

    public static void main(String[] args) {
	beispielZwei();
    }
}
