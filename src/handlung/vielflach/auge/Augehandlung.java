package handlung.vielflach.auge;

import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;
import druck.matrix.Matrixdrucker;
import druck.vektor.Vektordrucker;
import java.awt.event.KeyEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.vielflach.auge.Augesicht;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;
import dreher.achse.Achsedreher;
import handlung.Handlung;

public class Augehandlung extends Handlung {

    Maler m;
    Augesicht vas;
    Vielflachwelt vw;
    int mousevorx;
    int mousevory;

    public Augehandlung(Maler m,
			Augesicht vas,
			Vielflachwelt vw) {
	this.m = m;
	this.vas = vas;
	this.vw = vw;
    }
    
    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.vas.entfernung.zwei -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.vas.entfernung.zwei += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.vas.entfernung.eins -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.vas.entfernung.eins += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.vas.entfernung.drei += 10;
		veraendert = true;
		
	    } else if (kc == 'g') {
		this.vas.entfernung.drei -= 10;
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.vas.winkeleins += 0.05;
		veraendert = true;
		
	    } else if (kc == 'j') {
		this.vas.winkelzwei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'k') {
		this.vas.winkeldrei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'y') {
		this.vas.winkeleins -= 0.05;
		veraendert = true;
		
	    } else if (kc == 'u') {
		this.vas.winkelzwei -= 0.05;		
		veraendert = true;
		
	    } else if (kc == 'i') {
		this.vas.winkeldrei -= 0.05;		
		veraendert = true;
	    }
	    
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
