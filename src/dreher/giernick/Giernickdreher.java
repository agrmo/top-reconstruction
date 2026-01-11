package dreher.giernick;

import vektor.Zweivektor;
import vektor.Dreivektor;
import dreher.vektor.Vektordreher;

public class Giernickdreher {

    // Drehen den Vektor zweimal: einmal in der xz-Fläche, und einmal
    // in der yz-Fläche.
    public static Dreivektor drehen(Dreivektor p, double gier, double nick) {
	// Drehen den Vektor in der xz-Fläche (um die y-Achse).
	Zweivektor xz = Vektordreher.drehen(new Zweivektor(p.eins, p.drei), gier);

	// Drehen den Vektor in der yz-Fläche (um die x-Achse).
	Zweivektor yz = Vektordreher.drehen(new Zweivektor(p.zwei, xz.zwei), nick);

	// Nehmen die x, y und z-Teile.
	double x = xz.eins;
	double y = yz.eins;
	double z = yz.zwei;

	// Der Vektor ist gedreht um die zwei Flächen.
	Dreivektor pgedreht = new Dreivektor(x, y, z);

	return pgedreht;
    }
}
