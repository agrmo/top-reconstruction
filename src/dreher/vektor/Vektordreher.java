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
// Fur die dritte Dimension
// ...
public class Vektordreher {

    public Vektordreher() {
	
    }

    // Dreh einen zweidimensionalen Vektor um den Ursprung.  Gegen den
    // Uhrzeigersinn. Theta hat die Einheit Rad.
    public static Zweivektor drehen(Zweivektor zp, double theta) {
	double xNeu = Math.cos(theta)*zp.eins - Math.sin(theta)*zp.zwei;
	double yNeu = Math.sin(theta)*zp.eins + Math.cos(theta)*zp.zwei;

	return new Zweivektor(xNeu, yNeu);
    }

    // Dreh einen dreidimensionalen Vektor um die x-Achse.
    // public static Dreivektor drehenXAchse(Dreivektor dp) {
	
    //}

    // Dreh einen dreidimensionalen Vektor um die y-Achse.
    // public static Dreivektor drehenYAchse(Dreivektor dp) {
	
    // }

    // Dreh einen dreidimensionalen Vektor um die z-Achse.
    // public static Dreivektor drehenZAchse(Dreivektor dp) {
	
    // }

    // Dreh einen zweidimensionalen Vektor nicht um den Ursprung,
    // sondern um den anderen gegebenen Vektor.
    // public static Zweivektor drehen(Zweivektor vektor, Zweivektor drehvektor)

    // Dreh einen dreidimensionalen Vektor nicht um den Ursprung,
    // sondern um den anderen gegebenen Vektor.
    // public static Dreivektor drehen(Dreivektor vektor, Dreivektor drehvektor)
}

