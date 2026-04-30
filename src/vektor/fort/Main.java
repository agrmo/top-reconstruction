package vektor.fort;

import druck.vektor.Vektordrucker;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes vektor.fort.Main
*/

public class Main {
    static void beispieleins() {
	Zweivektor va = new Zweivektor(3,5);
	double b = 5.8309;
	Zweivektor vb = Zweifortvektor.mache(va, b);
	System.out.println(Vektordrucker.drucke(vb));
	    
	// Soll den gleichen Vektor ausgeben.
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
