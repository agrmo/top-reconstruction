package dreher.punkt;

import dreher.vektor.Vektordreher;
import matrix.Dreimatrix;
import matrix.Zweimatrix;
import vektor.Dreivektor;
import vektor.Zweivektor;

/*
  Ähnlich wie der Achsedreher stellen wir eine klare und bestimmte
  Frage und benennen dem Problem einen schlechten Namen.

  Frage: Wie drehen wir einen Vektor um einen Punkt herum?

  Antwort: ein "Punktdreher"
  1. Nenne den Vektor zu drehen va
  2. Nenne den Drehpunkt drehpunkt
  3. Subtrahiere teilweise drehpunkt von va. d.h. vb = va - drehpunkt
  4. Drehe vb mit der gegebenen Drehmatrix -> vc
  5. Addiere teilweise drehpunkt zu vc. d.h. vd = vc + drehpunkt
  6. Gebe vd aus
 */
public class Punktdreher {

    public static Zweivektor drehe(Zweivektor va, Zweivektor drehpunkt, Zweimatrix drehung) {
	va.subtrahiere(drehpunkt);
	Zweivektor vb = drehung.punkt(va);
	vb.addiere(drehpunkt);
	
	return vb;
    }
}

