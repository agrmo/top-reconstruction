package spiel.vielflach.auge;

import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.vielflach.auge.Augesicht;
import spiel.Spiel;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;

public class Augespiel extends Spiel {

    Maler m;
    Augesicht vas;
    Vielflachwelt vw;
    int mousevorx;
    int mousevory;

    public Augespiel(Maler m,
		     Augesicht vas,
		     Vielflachwelt vw) {
	this.m = m;
	this.vas = vas;
	this.vw = vw;

	this.mousevorx = 0;
	this.mousevory = 0;
    }
    
    public void handelnMouseDrucken(MouseEvent me) {
	this.mousevorx = me.getX();
	this.mousevory = me.getY();
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	this.mousevorx = 0;
	this.mousevory = 0;

	this.m.repaint();
    }
    
    public void handelnMouseEin(MouseEvent me) {
	// nichts
    }
    
    public void handelnMouseAus(MouseEvent me) {
	// nichts
    }
    
    public void handelnMouse(MouseEvent me) {
	// nichts
    }

    public void handelnMouseBewegen(MouseEvent me) {
	// nichts
    }

    // Bewegen die Augen.
    public void handelnMouseSchleifen(MouseEvent me) {
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedX = jetztx - this.mousevorx;
	int unterschiedY = jetzty - this.mousevory;
	double winkelgier = -((double) unterschiedX) / this.vas.breite;
	double winkelnick = ((double) unterschiedY) / this.vas.hoehe;

	Dreimatrix giermatrix = Matrixdreher.machedrehery(winkelgier);
	Dreimatrix nickmatrix = Matrixdreher.machedreherx(winkelnick);

	this.vas.augevektor = nickmatrix.punkt(this.vas.augevektor);
	this.vas.augevektor = giermatrix.punkt(this.vas.augevektor);
	
	this.mousevorx = jetztx;
	this.mousevory = jetzty;

	this.m.repaint();
    }
    
    public void handelnTastatur(KeyEvent ke) {
	// nichts
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	// nichts
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
