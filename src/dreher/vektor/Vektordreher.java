package dreher.vektor;

import vektor.Zweivektor;
import vektor.Dreivektor;

// Ein Vektordreher dreht einen Vektor um eine Achse. Die Achse ist
// entweder die x-, y- oder z-Achse.
//
// Für die zweite Dimension
// x' = cos(theta) x - sin(theta) y
// y' = sin(theta) x + cos(theta) y
//
// Fur die dritte Dimension gibt es:
// - Eine Drehung um die x-Achse
// - Eine Drehung um die y-Achse
// - Eine Drehung um die z-Achse
//
// Wir sollen eine allgemeine Drehung mit dieser drei einheitliche
// Drehungen aufbauen.
public class Vektordreher {

    public Vektordreher() {
	
    }

    // Dreh einen zweidimensionalen Vektor um den Ursprung gegen den
    // Uhrzeigersinn. Theta hat die Einheit Rad.
    public static Zweivektor drehen(Zweivektor zp, double theta) {
	double xNeu = Math.cos(theta)*zp.eins - Math.sin(theta)*zp.zwei;
	double yNeu = Math.sin(theta)*zp.eins + Math.cos(theta)*zp.zwei;

	return new Zweivektor(xNeu, yNeu);
    }

    // Drehen den Vektor in um die x-Achse (in die yz-Fläche). Es
    // heißt Nick.
    public static Dreivektor drehenX(Dreivektor p, double theta) {

	Zweivektor yz = Vektordreher.drehen(new Zweivektor(p.zwei, p.drei), theta);

	// Der Vektor ist gedreht. Der x-Teil ist unverändert.
	// Die neue Teile der Vektor sind:
	// x ist p.eins
	// y ist yz.eins
	// z ist yz.zwei

	Dreivektor pgedreht = new Dreivektor(p.eins, yz.eins, yz.zwei);
	return pgedreht;
    }

    // Drehen den Vektor um die y-Achse (in die xz-Fläche). Es heißt
    // Gier.
    public static Dreivektor drehenY(Dreivektor p, double theta) {

	Zweivektor xz = Vektordreher.drehen(new Zweivektor(p.eins, p.drei), theta);
	
	// Der Vektor ist gedreht. Der y-Teil ist unverändert.
	// Die neue Teile der Vektor sind:
	// x ist xz.eins
	// y ist p.zwei
	// z ist xz.zwei

	Dreivektor pgedreht = new Dreivektor(xz.eins, p.zwei, xz.zwei);
	return pgedreht;
    }

    // Drehen den Vektor um die z-Achse (in die xy-Fläche). Es heißt Gier.
    public static Dreivektor drehenZ(Dreivektor p, double theta) {

	Zweivektor xy = Vektordreher.drehen(new Zweivektor(p.eins, p.zwei), theta);
	
	// Der Vektor ist gedreht. Der z-Teil ist unverändert.
	// Die neue Teile der Vektor sind:
	// x ist xy.eins
	// y ist xy.zwei
	// z ist p.drei

	Dreivektor pgedreht = new Dreivektor(xy.eins, xy.zwei, p.drei);
	return pgedreht;
    }

    // Dreh einen zweidimensionalen Vektor nicht um den Ursprung,
    // sondern um den anderen gegebenen Vektor.
    // public static Zweivektor drehen(Zweivektor vektor, Zweivektor drehvektor)

    // Dreh einen dreidimensionalen Vektor nicht um den Ursprung,
    // sondern um den anderen gegebenen Vektor.
    // public static Dreivektor drehen(Dreivektor vektor, Dreivektor drehvektor)
}

