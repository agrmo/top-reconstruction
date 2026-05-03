package handlung.bogen;

import handlung.Handlung;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import sicht.bogen.drei.Dreibogensicht;
import welt.bogen.Dreibogenwelt;

// Eine Handlung, das einige Bogen darstellt, und mit der Tastatur
// verändert werden kann.
public class Bogenhandlung extends Handlung {

    Maler m;
    Dreibogensicht dbs;
    Dreibogenwelt dbw;

    public Bogenhandlung(Maler m,
			 Dreibogensicht dbs,
			 Dreibogenwelt dbw) {
	this.m = m;
	this.dbs = dbs;
	this.dbw = dbw;
    }

    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.dbs.entfernung.zwei -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.dbs.entfernung.zwei += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.dbs.entfernung.eins -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.dbs.entfernung.eins += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.dbs.entfernung.drei += 10;
		veraendert = true;
		
	    } else if (kc == 'g') {
		this.dbs.entfernung.drei -= 10;
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.dbs.winkeleins += 0.05;
		veraendert = true;
		
	    } else if (kc == 'j') {
		this.dbs.winkelzwei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'k') {
		this.dbs.winkeldrei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'y') {
		this.dbs.winkeleins -= 0.05;
		veraendert = true;
		
	    } else if (kc == 'u') {
		this.dbs.winkelzwei -= 0.05;		
		veraendert = true;
		
	    } else if (kc == 'i') {
		this.dbs.winkeldrei -= 0.05;		
		veraendert = true;
	    }
	    
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
