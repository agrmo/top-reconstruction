package verdoppler.vektor;

import vektor.Dreivektor;
import vektor.Zweivektor;

public class Vektorverdoppler {

    public static Zweivektor verdoppele(Zweivektor p) {
	return new Zweivektor(p.eins, p.zwei);
    }

    public static Dreivektor verdoppele(Dreivektor p) {
	return new Dreivektor(p.eins, p.zwei, p.drei);
    }
}
