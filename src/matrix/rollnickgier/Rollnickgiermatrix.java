package matrix.rollnickgier;

import matrix.Dreimatrix;
import vektor.Dreivektor;
import dreher.matrix.Matrixdreher;

public class Rollnickgiermatrix {

    // Gegeben einen Punkt, was ist die einfachste Drehung mit den
    // Roll-, Nick- und Gierwinkeln?
    //
    // Wir müssen die Basisvektoren der Welt drehen, bevor wir die
    // Teile der Welt an der Augenfläche verlegen. Um das zu tun,
    // brauchen wir eine Matrix, die diese Drehung schaffen kann. Wir
    // können diese Matrix von dem Punkt der Augen nachvollziehen.
    public static Dreimatrix nehmebasisdrehungmatrix(Dreivektor augevektor) {
	double thetaroll = Math.atan(augevektor.drei / augevektor.eins);
	double thetanick = Math.atan(augevektor.drei / augevektor.zwei);
	double thetagier = Math.atan(augevektor.eins / augevektor.zwei);
	
	Dreimatrix matrixroll = Matrixdreher.machedrehery(thetaroll);
	Dreimatrix matrixnick = Matrixdreher.machedreherx(thetanick);
	Dreimatrix matrixgier = Matrixdreher.machedreherz(thetagier);

	Dreimatrix ma = matrixroll.punkt(matrixnick);
	Dreimatrix mb = ma.punkt(matrixgier);

	// mb ist alle 3 Drehungen zusammen.
	return mb;
    }
}
