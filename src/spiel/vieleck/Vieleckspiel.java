package spiel.vieleck;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import sicht.vieleck.Vielecksicht;
import spiel.Spiel;
import vektor.Zweivektor;
import verschieber.Verschieber;
import welt.vieleck.Vieleckwelt;

// Ein Spiel, in dem wir die Welt und Sichten verändern können.
//
// TGFH: Verschieben die ursprüngliche Vektoren der Vielflachwelt.
// Mouse: Drucken und verschieben gleichzeitig alle Körper.
public class Vieleckspiel extends Spiel {

    Maler m;
    Vieleckwelt welt;
    int mouseAnfangX;
    int mouseAnfangY;

    public Vieleckspiel(Maler m, Vieleckwelt welt) {
	this.m = m;
	this.welt = welt;

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

    // Verschiebe die ursprüngliche Vektoren der Welt nach dx, dy.
    void verschieben(int dx, int dy) {
	Zweivektor verschiebenvektor = new Zweivektor(dx,dy);
	Verschieber.verschieben(this.welt, verschiebenvektor);
    }
    
    public void handelnMouseSchleifen(MouseEvent me) {

	int jetztX = me.getX();
	int jetztY = me.getY();
	int unterschiedX = jetztX - this.mouseAnfangX;
	int unterschiedY = jetztY - this.mouseAnfangY;

	this.verschieben(unterschiedX, unterschiedY);
	
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.m.repaint();
    }
    
    public void handelnTastatur(KeyEvent ke) {
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
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	// nichts
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
