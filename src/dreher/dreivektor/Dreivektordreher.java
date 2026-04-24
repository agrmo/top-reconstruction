package dreher.dreivektor;

import vektor.Zweivektor;
import vektor.Dreivektor;
import dreher.zweivektor.Zweivektordreher;

// Ein Dreivektordreher dreht einen Vektor um eine Achse. Die Achse
// ist entweder die x-, y- oder z-Achse.
//
// In drei Dimensionen gibt es
// - eine Drehung um die x-Achse
// - eine Drehung um die y-Achse
// - eine Drehung um die z-Achse
//
// Wir sollen eine allgemeine Drehung mit diesen drei einheitlichen
// Drehungen aufbauen.
public class Dreivektordreher {

    // Dreh den Vektor in um die x-Achse (in die yz-Fläche).
    public static Dreivektor drehex(Dreivektor p, double theta) {

	Zweivektor yz = Zweivektordreher.drehen(new Zweivektor(p.zwei, p.drei), theta);

	// Der Vektor ist gedreht. Der x-Teil ist unverändert.
	// Die neue Teile der Vektor sind:
	// x ist p.eins
	// y ist yz.eins
	// z ist yz.zwei

	Dreivektor pgedreht = new Dreivektor(p.eins, yz.eins, yz.zwei);
	return pgedreht;
    }

    // Dreh den Vektor um die y-Achse (in die xz-Fläche).
    public static Dreivektor drehey(Dreivektor p, double theta) {

	Zweivektor xz = Zweivektordreher.drehen(new Zweivektor(p.eins, p.drei), theta);
	
	// Der Vektor ist gedreht. Der y-Teil ist unverändert.
	// Die neue Teile der Vektor sind:
	// x ist xz.eins
	// y ist p.zwei
	// z ist xz.zwei

	Dreivektor pgedreht = new Dreivektor(xz.eins, p.zwei, xz.zwei);
	return pgedreht;
    }

    // Dreh den Vektor um die z-Achse (in die xy-Fläche).
    public static Dreivektor drehez(Dreivektor p, double theta) {

	Zweivektor xy = Zweivektordreher.drehen(new Zweivektor(p.eins, p.zwei), theta);
	
	// Der Vektor ist gedreht. Der z-Teil ist unverändert.
	// Die neue Teile der Vektor sind:
	// x ist xy.eins
	// y ist xy.zwei
	// z ist p.drei

	Dreivektor pgedreht = new Dreivektor(xy.eins, xy.zwei, p.drei);
	return pgedreht;
    }
}

