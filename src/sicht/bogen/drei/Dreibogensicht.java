package sicht.bogen.drei;

import auge.Auge;
import bogen.Bogen;
import dreher.euler.Eulerdreher;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.bogen.zwei.Zweibogensicht;
import vektor.Zweivektor;
import verleger.bogen.Bogenverleger;
import verleger.punkt.Punktverleger;
import welt.bogen.Dreibogenwelt;
import welt.bogen.Zweibogenwelt;

// Stellen eine Reihe von Bogen dar.
public class Dreibogensicht extends Sicht {

    // Die Welt.
    public Dreibogenwelt dbw;

    // Die Augen, mit denen wir uns die Welt anschauen werden.
    public Auge auge;
    
    public Dreibogensicht(Dreibogenwelt dbw, Auge auge) {
	this.dbw = dbw;
	this.auge = auge;
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
						 this.auge.winkeleins,
						 this.auge.winkelzwei,
						 this.auge.winkeldrei);

	    // Verlege den Ort.
	    zweiorte[i] = Punktverleger.verlege(this.dbw.stellungen[i].ort,
						this.auge.entfernung,
						this.auge.brennweite,
						this.auge.breite,
						this.auge.hoehe,
						Eulerdreher.nehmedrehung(this.dbw.stellungen[i].orientierung.winkeleins + this.auge.winkeleins,
									 this.dbw.stellungen[i].orientierung.winkelzwei + this.auge.winkelzwei,
									 this.dbw.stellungen[i].orientierung.winkeldrei + this.auge.winkeldrei));
	}
	
	Zweibogenwelt zbw = new Zweibogenwelt(zweibogen, zweiorte);

	Zweibogensicht zbs = new Zweibogensicht(zbw);

	zbs.darstellen(g);
    }
}


