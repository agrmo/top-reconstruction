package handlung;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sicht.linearschief.Linearschiefsicht;

public class Linearschieftastaturhandlung extends Handlung implements KeyListener {

    // Wir werden diese Sicht nach einer Berührung der Tastatur
    // anrufen, um sie sich wieder darzustellen.
    Linearschiefsicht lss;

    public Linearschieftastaturhandlung(Linearschiefsicht l) {
	this.lss = l;
    }
     
    public void keyPressed(KeyEvent e) {
	int keyCode = e.getKeyCode();
	boolean veraendert = false;
	    
	if (keyCode == 38) {
	    // Hoch getastet.
		
	    this.lss.lv.my *= 1.1;
	    veraendert = true;
		
	} else if (keyCode == 40) {
	    // Runter getastet.
		
	    this.lss.lv.my *= 0.9;
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
}
