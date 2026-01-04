package dreher.punkt;

import punkt.Zweipunkt;
import punkt.Dreipunkt;

// Ein Punktdreher dreht einen Punkt um eine Achse. Die Achse ist
// entweder die x-, y- oder z-Achse.
//
// Für die zweite Dimension
// x' = cos(theta) x - sin(theta) y
// y' = sin(theta) x + cos(theta) y
//
// Fur die dritte Dimension
// ...
public class Punktdreher {

    public Punktdreher() {
	
    }

    // Dreh einen zweidimensionalen Punkt um den Ursprung.
    //
    // Gegen den Uhrzeigersinn.
    public static Zweipunkt drehen(Zweipunkt zp, double thetaRad) {
	double xStrich = Math.cos(thetaRad)*zp.xteil - Math.sin(thetaRad)*zp.yteil;
	double yStrich = Math.sin(thetaRad)*zp.xteil + Math.cos(thetaRad)*zp.yteil;

	return new Zweipunkt(xStrich, yStrich);
    }

    // Dreh einen dreidimensionalen Punkt um die x-Achse.
    // public static Dreipunkt drehenXAchse(Dreipunkt dp) {
	
    //}

    // Dreh einen dreidimensionalen Punkt um die y-Achse.
    // public static Dreipunkt drehenYAchse(Dreipunkt dp) {
	
    // }

    // Dreh einen dreidimensionalen Punkt um die y-Achse.
    // public static Dreipunkt drehenZAchse(Dreipunkt dp) {
	
    // }

    // Dreh einen zweidimensionalen Punkt nicht um den Ursprung,
    // sondern um den anderen gegebenen Punkt.
    // public static Zweipunkt drehen(Zweipunkt punkt, Zweipunkt drehpunkt)

    // Dreh einen dreidimensionalen Punkt nicht um den Ursprung,
    // sondern um den anderen gegebenen Punkt.
    // public static Dreipunkt drehen(Dreipunkt punkt, Dreipunkt drehpunkt)
}

