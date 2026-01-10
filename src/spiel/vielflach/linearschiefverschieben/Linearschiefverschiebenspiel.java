package spiel.vielflach.linearschiefverschieben;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import punkt.Dreipunkt;
import sicht.vielflach.linearschief.Linearschiefsicht;
import spiel.Spiel;
import verschieber.Verschieber;
import welt.vielflach.Vielflachwelt;
import maler.Maler;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// WSAD: Verschieben die Sicht mit Hilfe der Linearschiefsicht
// TGFH: Verschieben die ursprüngliche Punkten der Vielflachwelt.
// []: Verschieben die Tiefe der Schiefsicht.
// Hoch Runter Links Rechts: Verschieben die Sicht verhältnismäßig.
// Mouse: Drucken und verschieben die Körper.
public class Linearschiefverschiebenspiel extends Spiel {

    Maler m;
    Linearschiefsicht lss;
    Vielflachwelt kw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Linearschiefverschiebenspiel(Maler m,
					Linearschiefsicht l,
					Vielflachwelt kw) {
	this.m = m;
	this.lss = l;
	this.kw = kw;

	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;
    }
    
    public void handelnMouseDrucken(MouseEvent me) {
	this.mouseAnfangX = me.getX();
	this.mouseAnfangY = me.getY();
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	this.mouseAnfangX = 0;
	this.mouseAnfangY = 0;
    }
    
    public void handelnMouseEin(MouseEvent me) {
	// nichts
    }
    
    public void handelnMouseAus(MouseEvent me) {
	// nichts
    }
    
    public void handelnMouse(MouseEvent me) {
	// nichts
    }

    public void handelnMouseBewegen(MouseEvent me) {
	// nichts
    }
    
    public void handelnMouseSchleifen(MouseEvent me) {

	int jetztX = me.getX();
	int jetztY = me.getY();
	int unterschiedX = jetztX - this.mouseAnfangX;
	int unterschiedY = jetztY - this.mouseAnfangY;
	this.lss.bx += unterschiedX;
	this.lss.by += unterschiedY;
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.m.repaint();
    }

    // Verschiebe die ursprüngliche Punkten der Welt nach dx, dy, dz.
    void verschieben(int dx, int dy, int dz) {
	Dreipunkt verschiebenpunkt = new Dreipunkt(dx,dy,dz);
	Verschieber.verschieben(this.kw, verschiebenpunkt);
    }
    
    public void handelnTastatur(KeyEvent ke) {
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
    
    public void handelnTastaturDrucken(KeyEvent ke) {
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
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
