package handlung.vieleck;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import sicht.vieleck.Vielecksicht;
import vektor.Zweivektor;
import verschieber.Verschieber;
import welt.vieleck.Vieleckwelt;
import handlung.Handlung;

// Eine Handlung, in dem wir die Welt und Sichten verändern können.
//
// TGFH: Verschieben die ursprüngliche Vektoren der Vielflachwelt.
// Mouse: Drucken und verschieben gleichzeitig alle Körper.
public class Vieleckhandlung extends Handlung {

    Maler m;
    Vieleckwelt welt;
    int mouseAnfangX;
    int mouseAnfangY;

    public Vieleckhandlung(Maler m, Vieleckwelt welt) {
	this.m = m;
	this.welt = welt;

	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;
    }

    // Verschiebe die ursprüngliche Vektoren der Welt nach dx, dy.
    void verschiebe(int dx, int dy) {
	Zweivektor verschiebenvektor = new Zweivektor(dx,dy);
	Verschieber.verschiebe(this.welt, verschiebenvektor);
    }
    
    
    public void mousePressed(MouseEvent me) {
	this.mouseAnfangX = me.getX();
	this.mouseAnfangY = me.getY();
    }
    
    public void mouseReleased(MouseEvent me) {
	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;
    }
    
    public void mouseDragged(MouseEvent me) {

	int jetztX = me.getX();
	int jetztY = me.getY();
	int unterschiedx = jetztX - this.mouseAnfangX;
	int unterschiedy = jetztY - this.mouseAnfangY;

	this.verschiebe(unterschiedx, unterschiedy);
	
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.m.repaint();
    }
    
    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.verschiebe(0,-10);
		veraendert = true;		
	    } else if (kc == 's') {
		this.verschiebe(0,10);
		veraendert = true;		
	    } else if (kc == 'a') {
		this.verschiebe(-10,0);
		veraendert = true;
	    } else if (kc == 'd') {
		this.verschiebe(10,0);
		veraendert = true;
	    }
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
}
