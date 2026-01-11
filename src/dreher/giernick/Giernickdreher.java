package dreher.giernick;

import punkt.Zweipunkt;
import punkt.Dreipunkt;
import dreher.punkt.Punktdreher;

public class Giernickdreher {

    // Drehen den Punkt zweimal: einmal in der xz-Fläche, und einmal
    // in der yz-Fläche.
    public static Dreipunkt drehen(Dreipunkt p, double gier, double nick) {
	// Drehen den Punkt in der xz-Fläche (um die y-Achse).
	Zweipunkt xz = Punktdreher.drehen(new Zweipunkt(p.xteil, p.zteil), gier);

	// Drehen den Punkt in der yz-Fläche (um die x-Achse).
	Zweipunkt yz = Punktdreher.drehen(new Zweipunkt(p.yteil, xz.yteil), nick);

	// Nehmen die x, y und z-Teile.
	double x = xz.xteil;
	double y = yz.xteil;
	double z = yz.yteil;

	// Der Punkt ist gedreht um die zwei Flächen.
	Dreipunkt pgedreht = new Dreipunkt(x, y, z);

	return pgedreht;
    }
}
