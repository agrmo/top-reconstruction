package vektor.fort.drei;

import druck.vektor.Vektordrucker;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes vektor.fort.drei.Main
*/

public class Main {
    static void beispieleins() {
	Dreivektor va = new Dreivektor(4,5,6);
	double b = 8.7749;
	Dreivektor vb = Dreifortvektor.mache(va, b);
	System.out.println(Vektordrucker.drucke(vb));
	    
	// Soll den gleichen Vektor ausgeben.
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
