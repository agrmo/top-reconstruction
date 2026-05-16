package handlung.auge;

import auge.Auge;
import handlung.Handlung;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;

// Diese Augehandlung ergibt viele Vorteile. Wir brauchen nicht,
// welche Sichten in der Lage steht, sondern nur die Eigenschaften der
// Augen. Deshalb können wir einfach nur diese Augen erzeugen und in
// der Handlung herein bringen, und die gleiche Augen in der Sichten
// hinein bringen. Darum brauchen wir nicht, die bestimmte Sichten zu
// kennen!
//
// Der Nachteil ist, daß die Handlung nicht in der Lage ist, die
// Eigenschaften und Körper bearbeiten.
public class Augehandlung extends Handlung {

    Maler maler;
    Auge auge;
    
    public Augehandlung(Maler maler, Auge auge) {
	this.maler = maler;
	this.auge = auge;
    }

    // Diese Handlung kann nur die Eigenschaften der Augen
    // verändern. Das reicht für uns!
    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.auge.entfernung.zwei -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.auge.entfernung.zwei += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.auge.entfernung.eins -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.auge.entfernung.eins += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.auge.entfernung.drei += 10;
		veraendert = true;
		
	    } else if (kc == 'g') {
		this.auge.entfernung.drei -= 10;
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.auge.winkeleins += 0.05;
		veraendert = true;
		
	    } else if (kc == 'j') {
		this.auge.winkelzwei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'k') {
		this.auge.winkeldrei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'y') {
		this.auge.winkeleins -= 0.05;
		veraendert = true;
		
	    } else if (kc == 'u') {
		this.auge.winkelzwei -= 0.05;		
		veraendert = true;
		
	    } else if (kc == 'i') {
		this.auge.winkeldrei -= 0.05;		
		veraendert = true;
	    }
        }

	// Der Maler kennt schon die Reihe von Sichten.
	if (veraendert == true) {
	    this.maler.repaint();
	}
    }
}
