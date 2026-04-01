package spiel.vielflach.augezeit;

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
import zeit.Zeitdauer;
import wesen.Vielflachbasiswesen;

public class Augezeitspiel extends Spiel {

    Maler m;
    Augesicht as;
    Vielflachwelt vw;
    int mousevorx;
    int mousevory;
    Vielflachbasiswesen vbw;

    public Augezeitspiel(Maler m,
			 Augesicht as,
			 Vielflachwelt vw) {
	this.m = m;
	this.as = as;
	this.vw = vw;
	this.vbw = new Vielflachbasiswesen(as, m);

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
    
    public void handelnMouseSchleifen(MouseEvent me) {
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedX = jetztx - this.mousevorx;
	int unterschiedY = jetzty - this.mousevory;
	double winkelgier = ((double) unterschiedX) / this.as.breite;
	double winkelnick = -((double) unterschiedY) / this.as.hoehe;

	Dreimatrix giermatrix = Matrixdreher.machedrehery(winkelgier);
	Dreimatrix nickmatrix = Matrixdreher.machedreherx(winkelnick);

	this.as.augevektor = giermatrix.punkt(this.as.augevektor);
	this.as.augevektor = nickmatrix.punkt(this.as.augevektor);
	
	this.mousevorx = jetztx;
	this.mousevory = jetzty;

	this.m.repaint();
    }
    
    public void handelnTastatur(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();
	    
	    if (kc == ' ') {
		Zeitdauer.anfangen(this.vbw);
		veraendert = true;		
	    }
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	// nichts
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
