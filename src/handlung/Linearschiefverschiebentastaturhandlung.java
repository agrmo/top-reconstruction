package handlung;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sicht.linearschiefverschieben.Linearschiefverschiebensicht;

public class Linearschiefverschiebentastaturhandlung extends Handlung implements KeyListener {

    // Wir werden diese Sicht nach einer Berührung der Tastatur
    // anrufen, um sie sich wieder darzustellen.
    Linearschiefverschiebensicht sicht;

    public Linearschiefverschiebentastaturhandlung(Linearschiefverschiebensicht l) {
	this.sicht = l;
    }
     
    public void keyPressed(KeyEvent e) {
	int keyCode = e.getKeyCode();
	boolean veraendert = false;
	    
	if (keyCode == 38) {
	    // Hoch getastet.
		
	    this.sicht.lv.my *= 1.1;
	    veraendert = true;
		
	} else if (keyCode == 40) {
	    // Runter getastet.
		
	    this.sicht.lv.my *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 37) {
	    // Links getastet.

	    this.sicht.lv.mx *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 39) {
	    // Rechts getastet.
		
	    this.sicht.lv.mx *= 1.1;
	    veraendert = true;
	}

	if (veraendert == true) {
	    this.sicht.repaint();
	}
    }
     
    public void keyReleased(KeyEvent e) {
        // Tue nichts.
    }

    // Eine Taste ist für diese Linearschiefsicht getastet. 
    public void keyTyped(KeyEvent e) {
	int id = e.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = e.getKeyChar();

	    if (kc == 'w') {
		this.sicht.lv.by -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.sicht.lv.by += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.sicht.lv.bx -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.sicht.lv.bx += 10.0;
		veraendert = true;
		
	    } else if (kc == '[') {
		this.sicht.sv.a += 0.1;
		veraendert = true;
		
	    } else if (kc == ']') {
		this.sicht.sv.a -= 0.1;
		veraendert = true;
		
	    }
        }

	if (veraendert == true) {
	    this.sicht.repaint();
	}
    }     
}
