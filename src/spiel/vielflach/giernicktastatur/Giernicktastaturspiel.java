package spiel.vielflach.giernicktastatur;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import punkt.Dreipunkt;
import sicht.vielflach.giernick.Giernicksicht;
import spiel.Spiel;
import welt.vielflach.Vielflachwelt;
import maler.Maler;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// WSAD: Verschieben das Auge
// Mouse: Drehen das Auge
public class Giernicktastaturspiel extends Spiel {

    Maler m;
    Giernicksicht as;
    Vielflachwelt kw;

    public Giernicktastaturspiel(Maler m,
				 Giernicksicht as,
				 Vielflachwelt kw) {
	this.m = m;
	this.as = as;
	this.kw = kw;
    }
    
    public void handelnMouseDrucken(MouseEvent me) {
	// nichts
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	// nichts
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
	// nichts
    }

    // Verschiebe die ursprüngliche Punkten der Welt nach dx, dy, dz.
    void verschiebenauge(int dx, int dy, int dz) {
	Dreipunkt verschiebenpunkt = new Dreipunkt(dx,dy,dz);
	this.as.augepunkt.addieren(verschiebenpunkt);
    }
    
    public void handelnTastatur(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.verschiebenauge(0,10,0);
		veraendert = true;
		
	    } else if (kc == 's') {
		this.verschiebenauge(0,-10,0);
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.verschiebenauge(10,0,0);
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.verschiebenauge(-10,0,0);
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
