package spiel.auge;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import punkt.Dreipunkt;
import sicht.auge.Augesicht;
import spiel.Spiel;
import welt.koerper.Koerperwelt;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// WSAD: Verschieben das Auge
// Mouse: Drehen das Auge
public class Augespiel extends Spiel {

    Augesicht as;
    Koerperwelt kw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Augespiel(Augesicht as,
		     Koerperwelt kw) {
	this.as = as;
	this.kw = kw;

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
	double unterschiedYaw = ((double) unterschiedX) / ((double) this.as.breite);
	double unterschiedPitch = ((double) unterschiedY) / ((double) this.as.hoehe);

	this.as.yaw -= unterschiedYaw;
	this.as.pitch += unterschiedPitch;
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.as.repaint();
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
		
	    } else if (kc == 't') {
		//
	    } else if (kc == 'g') {
		//
	    } else if (kc == 'f') {
		//
	    } else if (kc == 'h') {
		//
	    } else if (kc == '[') {
		//
	    } else if (kc == ']') {
		//
	    }
        }

	if (veraendert == true) {
	    this.as.repaint();
	}
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	int keyCode = ke.getKeyCode();
	boolean veraendert = false;
	    
	if (keyCode == 38) {
	    // Hoch getastet.
	} else if (keyCode == 40) {
	    // Runter getastet.
	} else if (keyCode == 37) {
	    // Links getastet.
	} else if (keyCode == 39) {
	    // Rechts getastet.
	}

	if (veraendert == true) {
	    this.as.repaint();
	}
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
