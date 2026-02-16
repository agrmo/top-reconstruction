package vektor;

// Es gibt zwei Sinne, in denen man Vektoren benutzen kann:
// 1. Ein Vektor ohne einen Ursprung
// 2. Ein Punkt, mit einem bestimmten Ursprung
//
// Es gibt keinen Sinn, die gleiche Datenstruktur für "Punkt" und auch
// "Vektor" zu schreiben. Also benutzen wir den Vektor für die beiden.
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
