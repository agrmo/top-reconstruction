package spiel.linearschief;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import sicht.koerper.linearschief.Linearschiefsicht;
import spiel.Spiel;
import maler.Maler;

// Ein Spiel mit einer Linearschiefsicht einer Körperwelt mit der
// Tastatur.  Ein linearschiefes Spiel enthält eine Handlung, eine
// Körperwelt und eine Sicht. Die Handlung enthält auch die Sicht,
// weil sie beiden sie wiederdarstellen sollen.
public class Linearschiefspiel extends Spiel {

    // Der Maler.
    Maler maler;

    // Wir werden diese Sicht nach einer Berührung der Tastatur
    // anrufen, um sie sich wieder darzustellen.
    Linearschiefsicht lss;

    public Linearschiefspiel(Maler m, Linearschiefsicht l) {
	this.maler = m;
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

    public void handelnMouseBewegen(MouseEvent me) {
	// nichts
    }
    public void handelnMouseSchleifen(MouseEvent me) {
	// nichts
    }
    
    public void handelnTastatur(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.lss.by -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.lss.by += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.lss.bx -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.lss.bx += 10.0;
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
	    this.maler.repaint();
	}
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	int keyCode = ke.getKeyCode();
	boolean veraendert = false;
	    
	if (keyCode == 38) {
	    // Hoch getastet.
		
	    this.lss.my *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 40) {
	    // Runter getastet.
		
	    this.lss.my *= 1.1;
	    veraendert = true;
		
	} else if (keyCode == 37) {
	    // Links getastet.

	    this.lss.mx *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 39) {
	    // Rechts getastet.
		
	    this.lss.mx *= 1.1;
	    veraendert = true;
	}

	if (veraendert == true) {
	    this.maler.repaint();
	}
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
