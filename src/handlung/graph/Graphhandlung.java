package handlung.graph;

import dreher.dreimatrix.Dreimatrixdreher;
import dreher.vektor.Vektordreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.graph.drei.Dreigraphaugesicht;
import vektor.Dreivektor;
import welt.graph.Dreigraphwelt;
import handlung.Handlung;
import java.awt.event.KeyEvent;

// Eine Handlung, das einen dreidimensionalen Graph darstellt.
public class Graphhandlung extends Handlung {

    Maler m;
    Dreigraphaugesicht dgas;
    Dreigraphwelt dgw;

    public Graphhandlung(Maler m,
			 Dreigraphaugesicht dgas,
			 Dreigraphwelt dgw) {
	this.m = m;
	this.dgas = dgas;
	this.dgw = dgw;
    }

    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.dgas.entfernung.zwei -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.dgas.entfernung.zwei += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.dgas.entfernung.eins -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.dgas.entfernung.eins += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.dgas.entfernung.drei += 10;
		veraendert = true;
		
	    } else if (kc == 'g') {
		this.dgas.entfernung.drei -= 10;
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.dgas.winkeleins += 0.05;
		veraendert = true;
		
	    } else if (kc == 'j') {
		this.dgas.winkelzwei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'k') {
		this.dgas.winkeldrei += 0.05;		
		veraendert = true;
		
	    } else if (kc == 'y') {
		this.dgas.winkeleins -= 0.05;
		veraendert = true;
		
	    } else if (kc == 'u') {
		this.dgas.winkelzwei -= 0.05;		
		veraendert = true;
		
	    } else if (kc == 'i') {
		this.dgas.winkeldrei -= 0.05;		
		veraendert = true;
	    }
	    
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
