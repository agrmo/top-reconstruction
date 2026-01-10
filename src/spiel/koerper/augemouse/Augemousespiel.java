package spiel.koerper.augemouse;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import punkt.Dreipunkt;
import sicht.auge.Augesicht;
import spiel.Spiel;
import welt.koerper.Koerperwelt;
import maler.Maler;

public class Augemousespiel extends Spiel {

    Maler m;
    Augesicht as;
    Koerperwelt kw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Augemousespiel(Maler m,
			  Augesicht as,
			  Koerperwelt kw) {
	this.m = m;
	this.as = as;
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
	double unterschiedGier = ((double) unterschiedX) / ((double) this.as.breite);
	double unterschiedNick = ((double) unterschiedY) / ((double) this.as.hoehe);

	this.as.gier += unterschiedGier;
	this.as.nick += unterschiedNick;
	this.mouseAnfangX = jetztX;
	this.mouseAnfangY = jetztY;

	this.m.repaint();
    }
    
    public void handelnTastatur(KeyEvent ke) {
	// nichts
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	// nichts
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	// nichts
    }
}
