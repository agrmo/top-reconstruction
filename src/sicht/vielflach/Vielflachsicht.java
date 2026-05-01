package sicht.vielflach;

import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.strecke.zwei.Zweistreckesicht;
import vektor.Dreivektor;
import verleger.vielflach.Vielflachverleger;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer vektoren
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Vielflachsicht extends Sicht {

    // Die ursprünglichen Daten der Welt, aber nicht bearbeitet.
    public Vielflachwelt vw;

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

    public Vielflachsicht(Vielflachwelt vw,
		     Dreivektor entfernung, double brennweite,
		     double breite, double hoehe) {

	this.vw = vw;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.entfernung = entfernung;
	this.winkeleins = 0;
	this.winkelzwei = 0;
	this.winkeldrei = 0;
    }

    public void darstellen(Graphics g) {
	
	// Benutzen den Verleger.  
	Zweistreckewelt zsw = Vielflachverleger.verlege(this.vw, this.entfernung, this.brennweite,
							this.breite, this.hoehe,
							this.winkeleins,
							this.winkelzwei,
							this.winkeldrei);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Zweistreckesicht ss = new Zweistreckesicht(zsw);
	ss.darstellen(g);
    }
}
