package matrix.rollnickgier;

import druck.matrix.Matrixdrucker;
import druck.vektor.Vektordrucker;
import vektor.Dreivektor;

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
    
    public static void main(String[] args) {
	beispielEins();
    }
}
