package dreher.euler;

import matrix.Dreimatrix;
import dreher.dreimatrix.Dreimatrixdreher;

public class Eulerdreher {

    // Gegeben drei Zahlen, berechne die Matrix zum Drehung der
    // Basisvektoren. Die Zahlen bestimmen drei Eulerwinkel ZXZ.
    // 
    // 1. Drehung um z1-Achse. Ergibt neue Basis (x2,y2,z2)
    // 2. Drehung um x2-Achse. Ergibt neue Basis (x3,y3,z3)
    // 3. Drehung um z3-Achse. Ergibt neue Basis (x4,y4,z4)
    public static Dreimatrix nehmedrehung(double winkeleins,
					  double winkelzwei,
					  double winkeldrei) {

	Dreimatrix matrixeins = Dreimatrixdreher.nehmedreherx(winkeleins);
	Dreimatrix matrixzwei = Dreimatrixdreher.nehmedreherz(winkelzwei);
	Dreimatrix matrixdrei = Dreimatrixdreher.nehmedreherx(winkeldrei);

	return matrixeins.punkt(matrixzwei.punkt(matrixdrei));
    }
}

