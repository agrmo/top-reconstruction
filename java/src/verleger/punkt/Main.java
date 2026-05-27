package verleger.punkt;

import matrix.Dreimatrix;
import vektor.Dreivektor;
import vektor.Zweivektor;
import druck.vektor.Vektordrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.punkt.Main
*/

public class Main {
    public static void main(String[] args) {

	// Der Vektor zu drehen.
	Dreivektor va = new Dreivektor(1,1,1);

	// Eigenschaften der Ein-Punkt-Perspektive.
	Dreivektor entfernung = new Dreivektor(100,100,100);
	int breite = 1200;
	int hoehe = 600;
	int brennweite = 500;
	Dreimatrix drehung = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	

	Zweivektor vb = Punktverleger.verlege(va,
					      entfernung, brennweite,
					      breite, hoehe,
					      drehung);

	System.out.println(Vektordrucker.drucke(vb));
    }
}
