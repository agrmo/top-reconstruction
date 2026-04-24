package handlung.vielflach.augezeit;

import dreher.dreimatrix.Dreimatrixdreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.vielflach.auge.Augesicht;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;
import wesen.Vielflachbasiswesen;
import zeit.Zeitdauer;
import handlung.Handlung;

public class Augezeithandlung extends Handlung {

    Maler m;
    Augesicht as;
    Vielflachwelt vw;
    int mousevorx;
    int mousevory;
    Vielflachbasiswesen vbw;

    public Augezeithandlung(Maler m,
			    Augesicht as,
			    Vielflachwelt vw) {
	this.m = m;
	this.as = as;
	this.vw = vw;
	this.vbw = new Vielflachbasiswesen(as, m);

	this.mousevorx = 0;
	this.mousevory = 0;
    }

    public void mousePressed(MouseEvent me) {
	this.mousevorx = me.getX();
	this.mousevory = me.getY();
    }
    
    public void mouseReleased(MouseEvent me) {
	this.mousevorx = 0;
	this.mousevory = 0;

	this.m.repaint();
    }
        
    public void mouseDragged(MouseEvent me) {
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedx = jetztx - this.mousevorx;
	int unterschiedy = jetzty - this.mousevory;
	double winkelgier = ((double) unterschiedx) / this.as.breite;
	double winkelnick = -((double) unterschiedy) / this.as.hoehe;

	Dreimatrix giermatrix = Dreimatrixdreher.nehmedrehery(winkelgier);
	Dreimatrix nickmatrix = Dreimatrixdreher.nehmedreherx(winkelnick);

	this.as.entfernung = giermatrix.punkt(this.as.entfernung);
	this.as.entfernung = nickmatrix.punkt(this.as.entfernung);
	
	this.mousevorx = jetztx;
	this.mousevory = jetzty;

	this.m.repaint();
    }
    
    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();
	    
	    if (kc == ' ') {
		Zeitdauer.anfangen(this.vbw);
		veraendert = true;		
	    }
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
