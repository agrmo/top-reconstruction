package stellung;

import orientierung.Orientierung;
import vektor.Zweivektor;

// Eine Zweistellung ist ein Paar von:
// - dreidimensionaler Ort
// - double
//
// In zwei Dimensionen ist eine Stellung einfach nur eine Drehung um
// einer zweidimensionalen Fläche.
public class Zweistellung {

    public Zweivektor ort;
    public double orientierung;

    public Zweistellung(Zweivektor ort,
			double orientierung) {

	this.ort = ort;
	this.orientierung = orientierung;
    }
}
