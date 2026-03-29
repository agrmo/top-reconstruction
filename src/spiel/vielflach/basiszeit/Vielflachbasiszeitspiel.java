package spiel.vielflach.basiszeit;

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

public class Vielflachbasiszeitspiel extends Spiel {

    Maler m;
    Augesicht vas;
    Vielflachwelt vw;
    int mouseAnfangX;
    int mouseAnfangY;
    Vielflachbasiswesen vbw;

    public Vielflachbasiszeitspiel(Maler m,
				   Augesicht vas,
				   Vielflachwelt vw) {
	this.m = m;
	this.vas = vas;
	this.vw = vw;
	this.vbw = new Vielflachbasiswesen(vas, m);

	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;
    }
    
    public void handelnMouseDrucken(MouseEvent me) {
	this.mouseAnfangX = me.getX();
	this.mouseAnfangY = me.getY();
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;

	this.vas.vorbasis = this.vas.basis.punkt(this.vas.vorbasis);
	this.vas.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);

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
	int jetztX = me.getX();
	int jetztY = me.getY();
	int unterschiedX = jetztX - this.mouseAnfangX;
	int unterschiedY = jetztY - this.mouseAnfangY;
	double winkelGier = ((double) unterschiedX) / this.vas.breite;
	double winkelNick = -((double) unterschiedY) / this.vas.hoehe;

	Dreimatrix giermatrix = Matrixdreher.machedrehery(winkelGier);
	Dreimatrix nickmatrix = Matrixdreher.machedreherx(winkelNick);

	this.vas.basis = this.vas.basis.punkt(giermatrix);
	this.vas.basis = this.vas.basis.punkt(nickmatrix);
	
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

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
