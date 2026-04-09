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
import dreher.achse.Achsedreher;

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

    // Bewege die Augen.
    public void handelnMouseSchleifen(MouseEvent me) {
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedx = jetztx - this.mousevorx;
	int unterschiedy = jetzty - this.mousevory;
	double winkelx = ((double) unterschiedx) / this.vas.breite;
	double winkely = ((double) unterschiedy) / this.vas.hoehe;

	// this.vas.augevektor.eins += unterschiedx;
	this.vas.augevektor.drei += unterschiedy;
	
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
