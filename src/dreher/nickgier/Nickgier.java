package dreher.nickgier;

import vektor.Dreivektor;

public class Nickgier {

    // Gegeben einen Vektor v, berechne den Gierwinkel.
    public static double nehmegierwinkel(Dreivektor v) {
	double thetanick = Math.atan(v.drei / v.zwei);
	return thetanick;
    }

    // Gegeben einen Vektor v, berechne den Nickwinkel.
    public static double nehmenickwinkel(Dreivektor v) {
	double thetagier = Math.atan(v.eins / v.zwei);
	return thetagier;
    }

    // Es gibt keinen Rollwinkel für einen einzelnen Vektor.
    // nehmerollwinkel()
}

