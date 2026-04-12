package handlung.vielflach.schief;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import vektor.Dreivektor;
import sicht.vielflach.linearschief.Linearschiefsicht;
import verschieber.Verschieber;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// Eine Handlung, in dem wir die Welt und Sichten verändern können.
//
// WSAD: Verschieben die Sicht mit Hilfe der Linearschiefsicht
// TGFH: Verschieben die ursprüngliche Vektoren der Vielflachwelt.
// []: Verschieben die Tiefe der Schiefsicht.
// Hoch Runter Links Rechts: Verschieben die Sicht verhältnismäßig.
// Mouse: Drucken und verschieben das Vielflach.
public class Schiefhandlung implements MouseListener, MouseMotionListener, KeyListener {

    Maler m;
    Linearschiefsicht lss;
    Vielflachwelt vw;
    int mouseanfangx;
    int mouseanfangy;
    double anfangbx;
    double anfangby;

    public Schiefhandlung(Maler m,
			  Linearschiefsicht l,
			  Vielflachwelt vw) {
	this.m = m;
	this.lss = l;
	this.vw = vw;
    }
    
    public void mousePressed(MouseEvent me) {
	this.mouseanfangx = me.getX();
	this.mouseanfangy = me.getY();

	this.anfangbx = this.lss.bx;
	this.anfangby = this.lss.by;
    }
    
    public void mouseDragged(MouseEvent me) {

	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedx = jetztx - this.mouseanfangx;
	int unterschiedy = jetzty - this.mouseanfangy;
	this.lss.bx = this.anfangbx + unterschiedx;
	this.lss.by = this.anfangby + unterschiedy;
	
	this.m.repaint();
    }

    // Verschiebe die ursprüngliche Vektoren der Welt nach dx, dy, dz.
    void verschieben(int dx, int dy, int dz) {
	Dreivektor verschiebenvektor = new Dreivektor(dx,dy,dz);
	Verschieber.verschieben(this.vw, verschiebenvektor);
    }
    
    public void keyTyped(KeyEvent ke) {
	int id = ke.getID();
	boolean veraendert = false;
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = ke.getKeyChar();

	    if (kc == 'w') {
		this.lss.by -= 10.0;
		veraendert = true;
		
	    } else if (kc == 's') {
		this.lss.by += 10.0;
		veraendert = true;
		
	    } else if (kc == 'a') {
		this.lss.bx -= 10.0;
		veraendert = true;
		
	    } else if (kc == 'd') {
		this.lss.bx += 10.0;
		veraendert = true;
		
	    } else if (kc == 't') {
		this.verschieben(0,-10,0);
		veraendert = true;

	    } else if (kc == 'g') {
		this.verschieben(0,10,0);
		veraendert = true;
		
	    } else if (kc == 'f') {
		this.verschieben(-10,0,0);
		veraendert = true;
		
	    } else if (kc == 'h') {
		this.verschieben(10,0,0);
		veraendert = true;
		
	    } else if (kc == '[') {
		this.lss.sv.a += 0.1;
		veraendert = true;
		
	    } else if (kc == ']') {
		this.lss.sv.a -= 0.1;
		veraendert = true;
	    }
        }

	if (veraendert == true) {
	    this.m.repaint();
	}
    }
    
    public void keyPressed(KeyEvent ke) {
	int keyCode = ke.getKeyCode();
	boolean veraendert = false;
	    
	if (keyCode == 38) {
	    // Hoch getastet.
		
	    this.lss.my *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 40) {
	    // Runter getastet.
		
	    this.lss.my *= 1.1;
	    veraendert = true;
		
	} else if (keyCode == 37) {
	    // Links getastet.

	    this.lss.mx *= 0.9;
	    veraendert = true;
		
	} else if (keyCode == 39) {
	    // Rechts getastet.
		
	    this.lss.mx *= 1.1;
	    veraendert = true;
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

    public void mouseReleased(MouseEvent me) {
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
}
