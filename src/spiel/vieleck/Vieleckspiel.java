package spiel.vieleck;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import vektor.Zweivektor;
import sicht.vieleck.Vielecksicht;
import spiel.Spiel;
import verschieber.Verschieber;
import welt.vieleck.Vieleckwelt;
import maler.Maler;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// TGFH: Verschieben die ursprüngliche Vektoren der Vielflachwelt.
// Mouse: Drucken und verschieben gleichzeitig alle Körper.
public class Vieleckspiel extends Spiel {

    Maler m;
    Vieleckwelt fw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Vieleckspiel(Maler m, Vieleckwelt fw) {
	this.m = m;
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

    // Verschiebe die ursprüngliche Vektoren der Welt nach dx, dy.
    void verschieben(int dx, int dy) {
	Zweivektor verschiebenvektor = new Zweivektor(dx,dy);
	Verschieber.verschieben(this.fw, verschiebenvektor);
    }
    
    public void handelnMouseSchleifen(MouseEvent me) {

	int jetztX = me.getX();
	int jetztY = me.getY();
	int unterschiedX = jetztX - this.mouseAnfangX;
	int unterschiedY = jetztY - this.mouseAnfangY;

	this.verschieben(unterschiedX, unterschiedY);
	
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.m.repaint();
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
	    this.m.repaint();
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
	    this.m.repaint();
	}
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
