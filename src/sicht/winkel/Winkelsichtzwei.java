package sicht.winkel;

import java.awt.Graphics;
import sicht.Sicht;
import vektor.Zweivektor;
import dreher.zweivektor.Zweivektordreher;

// Stelle einen Winkel dar. 
public class Winkelsichtzwei extends Sicht {

    // Der Radiant des Winkels.
    // Nehmen wir an, daß der Winkel 0 < theta < 2pi ist.
    double winkel;

    // Radius des Kreises.
    int radius;

    // Größe des Nullpunkts
    int nullradius;

    // Bildschirm
    double breite;
    double hoehe;
    
    public Winkelsichtzwei(double winkel, double breite, double hoehe,
		       int radius, int nullradius) {
	this.winkel = winkel;
	this.breite = breite;
	this.hoehe = hoehe;
	this.radius = radius;
	this.nullradius = nullradius;
    }

    // Stelle den Winkel dar.
    void darstellebogen(Graphics g) {

	// Das Zentrum des Kreises ist auch das Zentrum des Bildschirms.
	int kreisx = (int) ((this.breite / 2.0) - this.radius);
	int kreisy = (int) ((this.hoehe / 2.0) - this.radius);

	int winkelanfang = 0;
	int winkelende = (int) (this.winkel * (180.0 / Math.PI));

	g.drawArc(kreisx, kreisy, this.radius * 2, this.radius * 2,
		  winkelanfang, winkelende);
    }

    // Darstelle die x-Achse und die y-Achse.
    void darstelleachsen(Graphics g) {

	// Wir können auch eine zweidimensionale Streckewlt bauen und
	// darstellen.

	// Linie für die x-Achse

	int xachselinksx = 0;
	int xachselinksy = (int) (this.hoehe / 2.0);

	int xachserechtsx = (int) this.breite;
	int xachserechtsy = (int) (this.hoehe / 2.0);

	// Linie für die y-Achse

	int yachseobenx = (int) (this.breite / 2.0);
	int yachseobeny = 0;

	int yachseuntenx = (int) (this.breite / 2.0);
	int yachseunteny = (int) this.hoehe;

	// Stelle dar.

	g.drawLine(xachselinksx, xachselinksy,
		   xachserechtsx, xachserechtsy);

	g.drawLine(yachseobenx, yachseobeny,
		   yachseuntenx, yachseunteny);
    }

    // Stelle einen Kreise für den Nullpunkt 0 Grad dar.
    public void darstelleendpunkt(Graphics g) {

	// Drehe den Nullpunkt zum Endpunkt des Bogens.
	Zweivektor a = new Zweivektor(this.radius, 0);
	Zweivektor b = Zweivektordreher.drehen(a, -this.winkel);

	// Verschiebe zum Zentrum des Bildschirms.
	int endpunktx = (int) (b.eins + (this.breite / 2.0) - this.nullradius);
	int endpunkty = (int) (b.zwei + (this.hoehe / 2.0) - this.nullradius);

	g.drawArc(endpunktx, endpunkty, this.nullradius * 2, this.nullradius * 2,
		  0, 360);
    }

    // Stelle die "Hypotenuse" des Bogens dar.
    public void darstellehypotenuse(Graphics g) {

	// Eine Seite der Strecke.
	int anfangx = (int)(this.breite / 2.0);
	int anfangy = (int)(this.hoehe / 2.0);

	// Ende der Strecke. Es liegt am Bogen.
	Zweivektor a = new Zweivektor(this.radius, 0);

	/* Sehr wichtig zu beachten:
	   Java benutzt eine zweidimensionale Fläche, wobei
	   +y nach unten geht. Das bedeutet, daß eine Drehung

	   ( cos -sin )
	   ( sin  cos )

	   geht nicht gegen den Uhrzeigersinn, sondern in den
	   Uhrseigersinn.

	   Wir müssen eine -1 in der Drehung einsetzen.

	   Wir müssen nicht eine -1 in drawArc() einsetzen.
	*/
	
	Zweivektor b = Zweivektordreher.drehen(a, -this.winkel);

	int endex = (int) (b.eins + (this.breite / 2.0));
	int endey = (int) (b.zwei + (this.hoehe / 2.0));

	g.drawLine(anfangx, anfangy, endex, endey);
    }

    // Stelle jeden Vektor dar.
    public void darstellen(Graphics g) {
	this.darstelleendpunkt(g);
	this.darstelleachsen(g);
	// this.darstellebogen(g);
	this.darstellehypotenuse(g);
    }
}

