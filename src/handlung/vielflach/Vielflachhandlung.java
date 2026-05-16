package handlung.vielflach;

import dreher.dreimatrix.Dreimatrixdreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.vielflach.Vielflachsicht;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;
import handlung.Handlung;

public class Vielflachhandlung extends Handlung {

    Maler m;
    Vielflachsicht vs;
    Vielflachwelt vw;
    int mousevorx;
    int mousevory;

    public Vielflachhandlung(Maler m,
			     Vielflachsicht vs,
			     Vielflachwelt vw) {
	this.m = m;
	this.vs = vs;
	this.vw = vw;
    }
    
    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.vs.auge.entfernung.zwei -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.vs.auge.entfernung.zwei += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.vs.auge.entfernung.eins -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.vs.auge.entfernung.eins += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.vs.auge.entfernung.drei += 10;
		veraendert = true;
		
	    } else if (kc == 'g') {
		this.vs.auge.entfernung.drei -= 10;
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.vs.auge.winkeleins += 0.03;
		veraendert = true;
		
	    } else if (kc == 'j') {
		this.vs.auge.winkelzwei += 0.03;		
		veraendert = true;
		
	    } else if (kc == 'k') {
		this.vs.auge.winkeldrei += 0.03;		
		veraendert = true;
		
	    } else if (kc == 'y') {
		this.vs.auge.winkeleins -= 0.03;
		veraendert = true;
		
	    } else if (kc == 'u') {
		this.vs.auge.winkelzwei -= 0.03;		
		veraendert = true;
		
	    } else if (kc == 'i') {
		this.vs.auge.winkeldrei -= 0.03;		
		veraendert = true;
	    }
	    
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
