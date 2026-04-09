package dreher.achse;

import vektor.Dreivektor;
import matrix.Dreimatrix;
import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;

public class Achsedreher {

    // Berechne die Drehungmatrix, um den Punkt auf die x-Achse zu
    // legen. Solche Drehung nennen wir "Achsedrehung" weil ich dumm
    // bin.
    public static Dreimatrix nehmexachsedrehung(Dreivektor va) {
	double thetaeins = Math.atan(va.drei / va.zwei);
	Dreivektor vb = Vektordreher.drehex(va, -1 * thetaeins);
	double thetazwei = Math.atan(vb.zwei / vb.eins);
	
	Dreimatrix ma = Matrixdreher.nehmedreherx(-1 * thetaeins);
	Dreimatrix mb = Matrixdreher.nehmedreherz(-1 * thetazwei);

	// Die richtige Ordnung der Multiplikation ist
	// ((mb*ma)*va)
	// sodaß va auf die x-Achse gelegt wird.
	
	return mb.punkt(ma);
    }

    // public static Dreimatrix nehmeyachsedrehung
    // public static Dreimatrix nehmezachsedrehung
}

