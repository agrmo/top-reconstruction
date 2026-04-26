package stellung;

import orientierung.Orientierung;
import vektor.Dreivektor;

// Eine Dreistellung ist ein Paar von:
// - dreidimensionaler Ort
// - Orientierung
public class Dreistellung {

    public Dreivektor ort;
    public Orientierung orientierung;

    public Dreistellung(Dreivektor ort,
			Orientierung orientierung) {

	this.ort = ort;
	this.orientierung = orientierung;
    }
}
