package vektor;

public class Vektor {

    // ein: Dreivektor
    // Addiere die zwei Dreivektor zu einem neuen Vektor.
    public static Dreivektor addiere(Dreivektor va, Dreivektor vb) {
	return new Dreivektor(va.eins + vb.eins,
			      va.zwei + vb.zwei,
			      va.drei + vb.drei);
    }

    // ein: Dreivektor
    // Multipliziere teilweise den gegebenen Dreivektor zu diesem.  
    public static Dreivektor punkt(Dreivektor va, Dreivektor vb) {
	return new Dreivektor(va.eins * vb.eins,
			      va.zwei * vb.zwei,
			      va.drei * vb.drei);
    }
}
