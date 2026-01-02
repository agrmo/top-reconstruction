package spiel.figur;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import punkt.Zweipunkt;
import sicht.figur.Figursicht;
import spiel.Spiel;
import verleger.verschieben.Verschiebenverleger;
import welt.figur.Figurwelt;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// WSAD: Verschieben die Sicht mit Hilfe der Figursicht
// TGFH: Verschieben die ursprüngliche Punkten der Körperwelt.
// []: Verschieben die Tiefe der Schiefsicht.
// Hoch Runter Links Rechts: Verschieben die Sicht verhältnismäßig.
// Mouse: Drucken und verschieben die Körper.
public class Figurspiel extends Spiel {

    Figursicht fs;
    Figurwelt fw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Figurspiel(Figursicht fs,
		      Figurwelt fw) {
	this.fs = fs;
	this.fw = fw;

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

	this.verschieben(unterschiedX, unterschiedY);
	
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.fs.repaint();
    }

    // Verschiebe die ursprüngliche Punkten der Welt nach dx, dy.
    void verschieben(int dx, int dy) {
	Zweipunkt verschiebenpunkt = new Zweipunkt(dx,dy);
	Verschiebenverleger.verschiebenWelt(this.fw, verschiebenpunkt);
    }
    
    public void handelnTastatur(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		
	    } else if (kc == 's') {
		
	    } else if (kc == 'a') {
		
	    } else if (kc == 'd') {
		
	    } else if (kc == 't') {
		this.verschieben(0,-10);
		veraendert = true;

	    } else if (kc == 'g') {
		this.verschieben(0,10);
		veraendert = true;
		
	    } else if (kc == 'f') {
		this.verschieben(-10,0);
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.verschieben(10,0);
		veraendert = true;
		
	    } else if (kc == '[') {
		
	    } else if (kc == ']') {
	    }
        }

	if (veraendert == true) {
	    this.fs.repaint();
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
	    this.fs.repaint();
	}
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
