package spiel.vielflach.giernickmouse;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import vektor.Dreivektor;
import sicht.vielflach.giernick.Giernicksicht;
import spiel.Spiel;
import welt.vielflach.Vielflachwelt;
import maler.Maler;

public class Giernickspiel extends Spiel {

    Maler m;
    Giernicksicht as;
    Vielflachwelt kw;
    int mouseanfangx;
    int mouseanfangy;
    double gieranfang;
    double nickanfang;

    public Giernickspiel(Maler m,
			      Giernicksicht as,
			      Vielflachwelt kw) {
	this.m = m;
	this.as = as;
	this.kw = kw;
    }
    
    public void handelnMouseDrucken(MouseEvent me) {
	this.mouseanfangx = me.getX();
	this.mouseanfangy = me.getY();

	this.gieranfang = this.as.gier;
	this.nickanfang = this.as.nick;
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	// nichts
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
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedx = jetztx - this.mouseanfangx;
	int unterschiedy = jetzty - this.mouseanfangy;
	double gierunterschied = ((double) unterschiedx) / this.as.breite;
	double nickunterschied = ((double) unterschiedy) / this.as.hoehe;

	this.as.gier = this.gieranfang + gierunterschied;
	this.as.nick = this.nickanfang + nickunterschied;
	
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
