package sicht.vielflach;

import auge.Auge;
import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.strecke.zwei.Zweistreckesicht;
import vektor.Dreivektor;
import verleger.vielflach.Vielflachverleger;
import welt.strecke.zwei.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer vektoren
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Vielflachsicht extends Sicht {

    // Die Welt.
    public Vielflachwelt vw;

    // Die Augen.
    public Auge auge;

    public Vielflachsicht(Vielflachwelt vw, Auge auge) {
	this.vw = vw;
	this.auge = auge;
    }

    public void darstellen(Graphics g) {
	
	// Benutzen den Verleger.  
	Zweistreckewelt zsw = Vielflachverleger.verlege(this.vw, this.auge);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Zweistreckesicht ss = new Zweistreckesicht(zsw);
	ss.darstellen(g);
    }
}
