package verdoppler.punkt;

import punkt.Dreipunkt;
import punkt.Zweipunkt;

public class Punktverdoppler {

    public static Zweipunkt verdoppeln(Zweipunkt p) {
	return new Zweipunkt(p.xteil, p.yteil);
    }

    public static Dreipunkt verdoppeln(Dreipunkt p) {
	return new Dreipunkt(p.xteil, p.yteil, p.zteil);
    }
}
