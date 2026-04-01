package matrix.rollnickgier;

import matrix.Dreimatrix;
import vektor.Dreivektor;
import dreher.matrix.Matrixdreher;

public class Rollnickgiermatrix {

    // Gegeben einen Augenvektor, berechne den Rollwinkel.
    public static Double nehmerollwinkel(Dreivektor augevektor) {	
	double thetaroll = Math.atan(augevektor.drei / augevektor.eins);
	return thetaroll;
    }

    // Gegeben einen Augenvektor, berechne den Gierwinkel.
    public static Double nehmegierwinkel(Dreivektor augevektor) {
	double thetanick = Math.atan(augevektor.drei / augevektor.zwei);
	return thetanick;
    }

    // Gegeben einen Augenvektor, berechne den Nickwinkel.
    public static Double nehmenickwinkel(Dreivektor augevektor) {
	double thetagier = Math.atan(augevektor.eins / augevektor.zwei);
	return thetagier;
    }

    // Gegeben einen Punkt, was ist die einfachste Drehung mit den
    // Roll-, Nick- und Gierwinkeln?
    //
    // Wir müssen die Basisvektoren der Welt drehen, bevor wir die
    // Teile der Welt an der Augenfläche verlegen. Um das zu tun,
    // brauchen wir eine Matrix, die diese Drehung schaffen kann. Wir
    // können diese Matrix von dem Punkt der Augen nachvollziehen.
    public static Dreimatrix nehmebasisdrehungmatrix(Dreivektor augevektor) {
	Double thetaroll = Rollnickgiermatrix.nehmerollwinkel(augevektor);
	Double thetagier = Rollnickgiermatrix.nehmegierwinkel(augevektor);
	Double thetanick = Rollnickgiermatrix.nehmenickwinkel(augevektor);
	
	Dreimatrix matrixroll = Matrixdreher.machedrehery(thetaroll);
	Dreimatrix matrixnick = Matrixdreher.machedreherx(thetanick);
	Dreimatrix matrixgier = Matrixdreher.machedreherz(thetagier);

	Dreimatrix ma = matrixroll.punkt(matrixgier);
	Dreimatrix mb = ma.punkt(matrixnick);

	// mb ist alle 3 Drehungen zusammen.
	return mb;
    }
}
