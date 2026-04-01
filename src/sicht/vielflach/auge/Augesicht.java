package sicht.vielflach.auge;

import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.strecke.Streckesicht;
import vektor.Dreivektor;
import verleger.auge.Augeverleger;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer vektoren
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Augesicht extends Sicht {

    // Die ursprünglichen Daten der Welt, aber nicht bearbeitet.
    public Vielflachwelt vw;

    // Die Eigenschaften dieser Augen.
    public double breite;
    public double brennweite;
    public double hoehe;

    // Der Augevektor. Er zeigt wovon wir uns die Welt anschauen.
    //
    // Wir müssen die Basis der Welt umdrehen, sodass die Dingen
    // innerhalb der Welt an der Augenfläche richtig verlegt werden.
    public Dreivektor augevektor;

    public Augesicht(Vielflachwelt vw,
		     Dreivektor augevektor, double brennweite,
		     double breite, double hoehe) {

	this.vw = vw;
	this.augevektor = augevektor;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
    }

    public void darstellen(Graphics g) {
	
	// Benutzen den Verleger.  
	Zweistreckewelt zsw = Augeverleger.verlegen(this.vw, this.augevektor, this.brennweite,
						    this.breite, this.hoehe);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ss = new Streckesicht(zsw);
	ss.darstellen(g);
    }
}
