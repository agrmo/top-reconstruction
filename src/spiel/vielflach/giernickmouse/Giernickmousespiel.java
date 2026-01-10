package spiel.vielflach.giernickmouse;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import punkt.Dreipunkt;
import sicht.vielflach.giernick.Giernicksicht;
import spiel.Spiel;
import welt.vielflach.Vielflachwelt;
import maler.Maler;

public class Giernickmousespiel extends Spiel {

    Maler m;
    Giernicksicht as;
    Vielflachwelt kw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Giernickmousespiel(Maler m,
			      Giernicksicht as,
			      Vielflachwelt kw) {
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
