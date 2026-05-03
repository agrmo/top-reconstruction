package sicht.bogen.drei;

import bogen.Bogen;
import dreher.euler.Eulerdreher;
import java.awt.Graphics;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.bogen.zwei.Zweibogensicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import verleger.bogen.Bogenverleger;
import verleger.punkt.Punktverleger;
import welt.bogen.Dreibogenwelt;
import welt.bogen.Zweibogenwelt;

// Stellen eine Reihe von Bogen dar.
public class Dreibogensicht extends Sicht {

    // Die Welt.
    Dreibogenwelt dbw;

    // Die Eigenschaften dieser Augen.
    public double breite;
    public double brennweite;
    public double hoehe;

    // Ein Vektor, mit dem wir die Weltkoordinaten verschieben
    // werden. Er funktioniert wie ein Augenpaar. Er zeigt wovon wir
    // uns die Welt anschauen.
    public Dreivektor entfernung;

    // Die Eulerwinkel.
    public double winkeleins;
    public double winkelzwei;
    public double winkeldrei;

    public Dreibogensicht(Dreibogenwelt dbw,
			  Dreivektor entfernung, double brennweite,
			  double breite, double hoehe,
			  double winkeleins,
			  double winkelzwei,
			  double winkeldrei) {
	this.dbw = dbw;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }

    public void darstellen(Graphics g) {

	// Liste von Bogen, deren Eigenschaften in zwei Dimensionen
	// verlegt sind.
	Bogen[] zweibogen = new Bogen[this.dbw.bogen.length];

	// Liste von zweidimensionalen Orten, an denen die verlegten
	// zweidimensionalen Bogen stehen.
	Zweivektor[] zweiorte = new Zweivektor[this.dbw.bogen.length];
	
	// Für jeden Bogen, verlege die Eigenschaften des Bogens und
	// auch den Ort, wo er steht. Deshalb wird alle Bogen
	// zweidimensional. Deshalb benutze die Zweibogensicht.
	
	for (int i = 0; i < this.dbw.bogen.length; i++) {
	    // Verlege den Bogen.
	    zweibogen[i] = Bogenverleger.verlege(this.dbw.bogen[i],
						 this.dbw.stellungen[i].orientierung,
						 this.winkeleins,
						 this.winkelzwei,
						 this.winkeldrei);

	    // Verlege den Ort.
	    zweiorte[i] = Punktverleger.verlege(this.dbw.stellungen[i].ort,
						this.entfernung,
						this.brennweite,
						this.breite,
						this.hoehe,
						Eulerdreher.nehmedrehung(this.dbw.stellungen[i].orientierung.winkeleins + this.winkeleins,
									 this.dbw.stellungen[i].orientierung.winkelzwei + this.winkelzwei,
									 this.dbw.stellungen[i].orientierung.winkeldrei + this.winkeldrei));
	}
	
	Zweibogenwelt zbw = new Zweibogenwelt(zweibogen,
					      zweiorte);

	Zweibogensicht zbs = new Zweibogensicht(zbw);

	zbs.darstellen(g);
    }
}


