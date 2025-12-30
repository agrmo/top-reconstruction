package spiel.linearschiefverschieben;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import sicht.linearschiefverschieben.Linearschiefverschiebensicht;
import spiel.Spiel;
import punkt.Dreipunkt;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// WSAD: Verschieben die Sicht mit Hilfe der Linearschiefsicht
// TGFH: Verschieben die ursprüngliche Punkten der Punktkörperwelt.
// []: Verschieben die Tiefe der Schiefsicht.
// Hoch Runter Links Rechts: Verschieben die Sicht verhältnismäßig.
public class Linearschiefverschiebenspiel extends Spiel {

    Linearschiefverschiebensicht lss;

    public Linearschiefverschiebenspiel(Linearschiefverschiebensicht l) {
	this.lss = l;
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
    
    public void handelnTastatur(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.lss.lv.by -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.lss.lv.by += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.lss.lv.bx -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.lss.lv.bx += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		Dreipunkt vp = new Dreipunkt(0,-1,0);
		this.lss.verschiebenpunkt = (vp);
		veraendert = true;

	    } else if (kc == 'g') {
		Dreipunkt vp = new Dreipunkt(0,1,0);
		this.lss.verschiebenpunkt = (vp);
		veraendert = true;
		
	    } else if (kc == 'f') {
		Dreipunkt vp = new Dreipunkt(-1,0,0);
		this.lss.verschiebenpunkt = (vp);
		veraendert = true;
		
	    } else if (kc == 'h') {
		Dreipunkt vp = new Dreipunkt(1,0,0);
		this.lss.verschiebenpunkt = (vp);
		veraendert = true;
		
	    } else if (kc == '[') {
		this.lss.sv.a += 0.1;
		veraendert = true;
		
	    } else if (kc == ']') {
		this.lss.sv.a -= 0.1;
		veraendert = true;
		
	    }
        }

	if (veraendert == true) {
	    this.lss.repaint();
	}
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	int keyCode = ke.getKeyCode();
	boolean veraendert = false;
	    
	if (keyCode == 38) {
	    // Hoch getastet.
		
	    this.lss.lv.my *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 40) {
	    // Runter getastet.
		
	    this.lss.lv.my *= 1.1;
	    veraendert = true;
		
	} else if (keyCode == 37) {
	    // Links getastet.

	    this.lss.lv.mx *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 39) {
	    // Rechts getastet.
		
	    this.lss.lv.mx *= 1.1;
	    veraendert = true;
	}

	if (veraendert == true) {
	    this.lss.repaint();
	}
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
