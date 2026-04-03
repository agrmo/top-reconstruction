package matrix.rollnickgier;

import druck.matrix.Matrixdrucker;
import druck.vektor.Vektordrucker;
import vektor.Dreivektor;
import matrix.Dreimatrix;
import dreher.matrix.Matrixdreher;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes matrix.rollnickgier.Main
*/

public class Main {
    static void beispielEins() {
	Dreivektor v = new Dreivektor(1,1,1);
	Double rollwinkel = Rollnickgiermatrix.nehmerollwinkel(v);
	Double gierwinkel = Rollnickgiermatrix.nehmegierwinkel(v);
	Double nickwinkel = Rollnickgiermatrix.nehmenickwinkel(v);
	
	System.out.println(rollwinkel);
	System.out.println(gierwinkel);
	System.out.println(nickwinkel);
	// 0.785 Rad = 45 Deg
    }

    static void beispielZwei() {
	
	// Drehen den Vektor [1,0,0] 90 Grad im Uhrzeigersinn um die Z-Achse.
	// Also bis [0,-1,0].
	Dreivektor va = new Dreivektor(1,0,0);
	Dreimatrix ma = Matrixdreher.nehmedreherz(Math.PI / 2.0);
	Dreivektor vb = ma.punkt(va);

	// Soll [0,-1,0] sein.
	System.out.println(Vektordrucker.drucken(vb));
    }

    static void beispielDrei() {

	// Verlegen den Vektor [0,0,1]
	Dreivektor va = new Dreivektor(1,1,1);
	Dreimatrix m = Rollnickgiermatrix.nehmebasisdrehungmatrix(va);
	Dreivektor vb = m.punkt(va);

	System.out.println(Vektordrucker.drucken(vb));
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
