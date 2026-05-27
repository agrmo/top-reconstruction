package dreher.achse;

import vektor.Dreivektor;
import matrix.Dreimatrix;
import dreher.dreimatrix.Dreimatrixdreher;
import dreher.dreivektor.Dreivektordreher;

/*
  Hier stellen wir die Frage: wie drehen wir einen Vektor, sodaß er
  parallel zu der x-Achse liegt?

  Ich habe noch keinen Nuzen dafür. Aber hier ist die Antwort.
 */
public class Achsedreher {
	
    // Berechne die Drehungmatrix, um den gegebenen Punkt auf die
    // x-Achse zu verlegen. Solche Drehung nennen wir "Achsedrehung"
    // weil ich dumm bin.
    public static Dreimatrix nehmexachsedrehung(Dreivektor va) {
	double thetaeins = Math.atan(va.drei / va.zwei);
	Dreivektor vb = Dreivektordreher.drehex(va, -1 * thetaeins);
	double thetazwei = Math.atan(vb.zwei / vb.eins);
	
	Dreimatrix ma = Dreimatrixdreher.nehmedreherx(-1 * thetaeins);
	Dreimatrix mb = Dreimatrixdreher.nehmedreherz(-1 * thetazwei);

	// Die richtige Ordnung der Multiplikation ist
	// ((mb*ma)*va)
	// sodaß va auf die x-Achse gelegt wird.
	
	return mb.punkt(ma);
    }

    // Die Umhekrung von nehmexachsedrehung.
    public static Dreimatrix nehmexachsedrehungumkehrung(Dreivektor va) {
	
	double thetaeins = Math.atan(va.drei / va.zwei);
	Dreivektor vb = Dreivektordreher.drehex(va, -1 * thetaeins);
	double thetazwei = Math.atan(vb.zwei / vb.eins);
	Dreimatrix ma = Dreimatrixdreher.nehmedreherx(thetaeins);
	Dreimatrix mb = Dreimatrixdreher.nehmedreherz(thetazwei);

	return ma.punkt(mb);
    }

    // public static Dreimatrix nehmeyachsedrehung
    // public static Dreimatrix nehmezachsedrehung
}

