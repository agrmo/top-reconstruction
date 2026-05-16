package verleger.bogen;

import bogen.Bogen;
import dreher.euler.Eulerdreher;
import vektor.Dreivektor;
import matrix.Dreimatrix;
import orientierung.Orientierung;
import spiegel.Spiegel;
import druck.vektor.Vektordrucker;

// Verlegt einen dreidimensionalen Bogen auf einer zweidimensionalen
// Fläche.
public class Bogenverleger {

    // Verlege den gegebenen Bogen.
    public static Bogen verlege(Bogen b, Orientierung s,
				double winkeleins,
				double winkelzwei,
				double winkeldrei) {

	/*
	  1. Nehme an, daß der Bogen am Anfang in der x-y-Fläche steht.
	  2. Die gegebene Orientierung dreht den Bogen aus der x-y-Fläche.

	  Die Breite und Höhe des Bogens wird einfach verändert.
	  1. Baue einen Einheitsvektor in der x-Achse und der y-Achse.
	  2. Drehe die Vektoren mit der Eulerdrehung.
	  3. Vom gedrehten x-Vektor nehme den x-Teil als neue Breite.
	  4. Vom gedrehten y-Vektor nehme den y-Teil als neue Höhe.
	  
	  Die Anfangswinkel und Unterschiedwinkel des Bogens sind ja
	  verändert, je nachdem, wie die Einheitsvektoren gedreht
	  wurden. Es gibt keine Lösung, die ich kenne, ohne Fälle zu
	  teilen.
	   
	  Falls der gekehrte y-Vektor negativ geht, müssen alle Winkel
	  um die x-Achse gespiegelt werden.

	  Falls der gekehrte x-Vektor negativ geht, müssen alle Winkel
	  um die y-Achse gespiegelt werden.

	  Das ist alles.
	*/

	Dreivektor anfangx = new Dreivektor(1,0,0);
	Dreivektor anfangy = new Dreivektor(0,1,0);

	Dreimatrix drehung = Eulerdreher.nehmedrehung(s.winkeleins + winkeleins,
						      s.winkelzwei + winkelzwei,
						      s.winkeldrei + winkeldrei);

	Dreivektor endx = drehung.punkt(anfangx);
	Dreivektor endy = drehung.punkt(anfangy);

	// StringBuilder sb = new StringBuilder();
	// sb.append(Vektordrucker.drucke(endx));
	// sb.append(" ");
	// sb.append(Vektordrucker.drucke(endy));
	// System.out.println(sb.toString());

	// Nehme den x-Teil von endx. Die zweidimensionale Breite.
	double zb = Math.abs(endx.eins) * b.breite;

	// Nehme den y-Teil von endy. Die zweidimensionale Höhe.
	double zh = Math.abs(endy.zwei) * b.hoehe;

	double anfangswinkel = b.anfangswinkel;
	double unterschiedwinkel = b.unterschiedwinkel;

	if (endy.zwei < 0) {
	    anfangswinkel = Spiegel.spiegelexgrad(anfangswinkel );
	    unterschiedwinkel = Spiegel.spiegelexgrad(unterschiedwinkel);
	}

	if (endx.eins < 0) {
	    anfangswinkel = Spiegel.spiegeleygrad(anfangswinkel);
	    unterschiedwinkel = Spiegel.spiegeleygrad(unterschiedwinkel);
	}

	return new Bogen(zb, zh, anfangswinkel, unterschiedwinkel);
    }
}
