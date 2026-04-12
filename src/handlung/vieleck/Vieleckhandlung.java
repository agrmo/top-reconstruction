package handlung.vieleck;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import sicht.vieleck.Vielecksicht;
import vektor.Zweivektor;
import verschieber.Verschieber;
import welt.vieleck.Vieleckwelt;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;

// Eine Handlung, in dem wir die Welt und Sichten verändern können.
//
// TGFH: Verschieben die ursprüngliche Vektoren der Vielflachwelt.
// Mouse: Drucken und verschieben gleichzeitig alle Körper.
public class Vieleckhandlung implements MouseListener, MouseMotionListener, KeyListener {

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
    
    public void mousePressed(MouseEvent me) {
	this.mouseAnfangX = me.getX();
	this.mouseAnfangY = me.getY();
    }
    
    public void mouseReleased(MouseEvent me) {
	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;
    }
    
    // Verschiebe die ursprüngliche Vektoren der Welt nach dx, dy.
    void verschieben(int dx, int dy) {
	Zweivektor verschiebenvektor = new Zweivektor(dx,dy);
	Verschieber.verschieben(this.welt, verschiebenvektor);
    }
    
    public void mouseDragged(MouseEvent me) {

	int jetztX = me.getX();
	int jetztY = me.getY();
	int unterschiedX = jetztX - this.mouseAnfangX;
	int unterschiedY = jetztY - this.mouseAnfangY;

	this.verschieben(unterschiedX, unterschiedY);
	
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
		this.verschieben(0,-10);
		veraendert = true;		
	    } else if (kc == 's') {
		this.verschieben(0,10);
		veraendert = true;		
	    } else if (kc == 'a') {
		this.verschieben(-10,0);
		veraendert = true;
	    } else if (kc == 'd') {
		this.verschieben(10,0);
		veraendert = true;
	    }
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }

    public void mouseExited(MouseEvent me) {
	// nichts
    }

    public void mouseEntered(MouseEvent me) {
	// nichts
    }
    
    public void mouseClicked(MouseEvent me) {
	// nichts
    }

    public void mouseMoved(MouseEvent me) {
	// nichts
    }

    public void keyReleased(KeyEvent ke) {
	// nichts
    }

    public void keyPressed(KeyEvent ke) {
	// nichts
    }
}
