package dreher.nickgier;

import vektor.Dreivektor;

public class Nickgier {

    // Gegeben einen Vektor v, berechne den Gierwinkel.
    public static double nehmegierwinkel(Dreivektor v) {
	double thetagier = Math.atan2(v.zwei, v.eins);
	return thetagier;
    }

    // Gegeben einen Vektor v, berechne den Nickwinkel.
    public static double nehmenickwinkel(Dreivektor v) {
	double hypotenuse = Math.sqrt((v.eins * v.eins) + (v.zwei * v.zwei));
	double thetanick = Math.atan2(v.eins, hypotenuse);
	return thetanick;
    }

    // Es gibt keinen Rollwinkel für einen einzelnen Vektor.
    // nehmerollwinkel()
}

