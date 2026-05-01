package handlung.vielflach;

import dreher.dreimatrix.Dreimatrixdreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.vielflach.Vielflachsicht;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;
import wesen.vielflach.Vielflachbasiswesen;
import zeit.Zeitdauer;
import handlung.Handlung;

public class Vielflachzeithandlung extends Handlung {

    Maler m;
    Vielflachsicht vs;
    Vielflachwelt vw;
    int mousevorx;
    int mousevory;
    Vielflachbasiswesen vbw;

    public Vielflachzeithandlung(Maler m,
				 Vielflachsicht vs,
				 Vielflachwelt vw) {
	this.m = m;
	this.vs = vs;
	this.vw = vw;
	this.vbw = new Vielflachbasiswesen(vs, m);

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
	double winkelgier = ((double) unterschiedx) / this.vs.breite;
	double winkelnick = -((double) unterschiedy) / this.vs.hoehe;

	Dreimatrix giermatrix = Dreimatrixdreher.nehmedrehery(winkelgier);
	Dreimatrix nickmatrix = Dreimatrixdreher.nehmedreherx(winkelnick);

	this.vs.entfernung = giermatrix.punkt(this.vs.entfernung);
	this.vs.entfernung = nickmatrix.punkt(this.vs.entfernung);
	
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
