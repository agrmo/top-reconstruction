package dreher.achse;

import vektor.Dreivektor;
import matrix.Dreimatrix;
import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;

public class Achsedreher {

    // Berechne die Drehungmatrix, um den Punkt auf die x-Achse zu
    // legen. Solche Drehung nennen wir "Achsedrehung" weil ich dumm
    // bin.
    public Dreimatrix nehmexachsedrehung(Dreivektor va) {
	double thetaeins = Math.atan(va.drei / va.zwei);
	Dreivektor vb = Vektordreher.drehenX(va, -1 * thetaeins);
	double thetazwei = Math.atan(vb.zwei / vb.eins);
	
	Dreimatrix ma = new Dreimatrix(0,0,0,0,0,0,0,0,0);

	return ma;
    }
}

