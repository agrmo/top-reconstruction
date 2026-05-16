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
		this.dbs.auge.entfernung.zwei -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.dbs.auge.entfernung.zwei += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.dbs.auge.entfernung.eins -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.dbs.auge.entfernung.eins += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.dbs.auge.entfernung.drei += 10;
		veraendert = true;
		
	    } else if (kc == 'g') {
		this.dbs.auge.entfernung.drei -= 10;
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.dbs.auge.winkeleins += 0.05;
		veraendert = true;
		
	    } else if (kc == 'j') {
		this.dbs.auge.winkelzwei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'k') {
		this.dbs.auge.winkeldrei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'y') {
		this.dbs.auge.winkeleins -= 0.05;
		veraendert = true;
		
	    } else if (kc == 'u') {
		this.dbs.auge.winkelzwei -= 0.05;		
		veraendert = true;
		
	    } else if (kc == 'i') {
		this.dbs.auge.winkeldrei -= 0.05;		
		veraendert = true;
	    }
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
