package verleger.bogen;

import bogen.Bogen;
import dreher.euler.Eulerdreher;
import vektor.Dreivektor;
import matrix.Dreimatrix;
import orientierung.Orientierung;

// Verlegt einen dreidimensionalen Bogen auf einer zweidimensionalen
// Fläche.
public class Bogenverleger {

    // Verlege den gegebenen Bogen.
    // 1. Nehme an, daß der Bogen am Anfang in der x-y-Fläche steht.
    // 2. Die gegebene Orientierung dreht den Bogen von der x-y-Fläche.
    public static Bogen verlege(Bogen b, Orientierung s,
				double winkeleins,
				double winkelzwei,
				double winkeldrei) {

	Dreivektor anfangx = new Dreivektor(1,0,0);
	Dreivektor anfangy = new Dreivektor(0,1,0);

	Dreimatrix drehung = Eulerdreher.nehmedrehung(s.winkeleins + winkeleins,
						      s.winkelzwei + winkelzwei,
						      s.winkeldrei + winkeldrei);

	Dreivektor endx = drehung.punkt(anfangx);
	Dreivektor endy = drehung.punkt(anfangy);

	// Nehme den x-Teil von endx. Die zweidimensionale Breite.
	double zb = endx.eins * b.breite;

	// Nehme den y-Teil von endy. Die zweidimensionale Höhe.
	// Ja, das Problem ist, daß zh nicht negativ sein kann...
	double zh = endy.zwei * b.hoehe;

	// Die Anfangswinkel und Unterschiedwinkel sind unverändert.

	return new Bogen(zb, zh, b.anfangswinkel, b.unterschiedwinkel);
    }
}
