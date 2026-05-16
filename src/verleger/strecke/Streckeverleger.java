package verleger.strecke;

import matrix.Dreimatrix;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import verleger.punkt.Punktverleger;

// Ein Streckeverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken.
//
// Schritte:
// 1. Berechne die nötige Drehung.
// 2. Drehe den Punkt.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektoren zum Zentrum des Bildchirms.
public class Streckeverleger {
    
    // ein: Dreistrecke, ...
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    public static Zweistrecke verlege(Dreistrecke ds,
				      Dreivektor entfernung, double brennweite,
				      double breite, double hoehe,
				      Dreimatrix drehung) {
	
	Zweivektor verlegtervektorvon = Punktverleger.verlege(ds.von,
							      entfernung, brennweite,
							      breite, hoehe,
							      drehung);
	
	Zweivektor verlegtervektorbis = Punktverleger.verlege(ds.bis,
							      entfernung, brennweite,
							      breite, hoehe,
							      drehung);
	
	// Die neue Strecke, die nur in zwei Dimensionen liegt.
	Zweistrecke zs = new Zweistrecke(verlegtervektorvon, verlegtervektorbis);
	
	return zs;
    }
}
