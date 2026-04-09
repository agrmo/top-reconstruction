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

	// Was ist die richtige Methode, um zwei Drehungen nacheinander zu ketten?
	// 1. Gegeben zwei Winkel, die den Vektor (50,50,50) auf die x-Achse legen kann.
	// 2. Nehme zwei Drehmatrizen von den zwei Winkeln, eine um die x-Achse und eine um die z-Achse.
	// 3. Wir wollen die zwei Matrizen schmelzen.
	// 4. Addieren wir die zwei Matrizen, oder
	// 4. Multiplizieren wir die zwei Matrizen?
	// 5. Wende die Matrix auf den Vektor (50,50,50) an.

	// Wir kennen schon, daß
	// thetaeins = -0.785 Rad um die x-Achse und nach dem
	// thetazwei = -0.955 Rad um die z-Achse
	// den Vektor (50,50,50)
	// auf die x-Achse verlegen kann.

	double thetaeins = -0.785;
	double thetazwei = -0.955;

	// Nehme die zwei Drehungmatrizen.
	Dreimatrix ma = Matrixdreher.nehmedreherx(thetaeins);
	Dreimatrix mb = Matrixdreher.nehmedreherz(thetazwei);

	// Was ist die richtige Anwendung der zwei Matrizen?

	// Wenn wir die zwei nicht gesammelte Matrizen anwenden, wird
	// der Vektor richtig auf die x-Achse gedreht?
	Dreivektor va = new Dreivektor(50,50,50);
	Dreivektor vb = ma.punkt(va);
	Dreivektor vc = mb.punkt(vb);

	System.out.println(Vektordrucker.drucken(vc));

	// Wenn wir die zwei Matrizen zuerst multiplizieren und
	// nachdem die endgültige Matrix anwenden, wird der Vektor
	// auch richtig auf die x-Achse gedreht?

	// Eigenlich ist ma.punkt(mb) nicht richtig.  mb.punkt(ma) ist
	// richtig.  Die Ordnung der Matrix-Multiplikation muss von
	// rechts nach links gezeigt wird.
	
	// Dreimatrix mc = mb.punkt(ma);
	// Dreivektor vd = mc.punkt(va);
	// oder auch
	Dreivektor vd = (mb.punkt(ma)).punkt(va);
	// ma ist die erste Drehung. Sie steht an der rechten Seite.

	System.out.println(Vektordrucker.drucken(vd));
    }

    static void beispielVier() {
    }
    
    public static void main(String[] args) {
	beispielDrei();
    }
}
