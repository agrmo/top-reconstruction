package dreher.euler;

import druck.vektor.Vektordrucker;
import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.euler.Main
*/

public class Main {
    static void beispieleins() {
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;

	Dreimatrix eulermatrix = Eulerdreher.nehmedrehung(winkeleins,
							  winkelzwei,
							  winkeldrei);

	Dreivektor va = new Dreivektor(1,1,1);
	Dreivektor vb = eulermatrix.punkt(va);
	
	StringBuilder sb = new StringBuilder();
	sb.append("Matrix:\n");
	sb.append(Matrixdrucker.drucke(eulermatrix));
	sb.append("\n");
	sb.append("Anwendung:\n");
	sb.append(Vektordrucker.drucke(va));
	sb.append("->");
	sb.append(Vektordrucker.drucke(vb));
	sb.append("\n");

	System.out.println(sb.toString());
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
