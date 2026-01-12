package spiel.vielflach.basismouse;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import vektor.Dreivektor;
import sicht.vielflach.basis.Basissicht;
import spiel.Spiel;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import dreher.vektor.Vektordreher;
import dreher.matrix.Matrixdreher;
import matrix.Dreimatrix;
import druck.matrix.Matrixdrucker;

public class Basismousespiel extends Spiel {

    Maler m;
    Basissicht as;
    Vielflachwelt kw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Basismousespiel(Maler m,
			   Basissicht as,
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

	this.as.vorbasis = this.as.basis.punkt(this.as.vorbasis);
	this.as.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);

	this.m.repaint();
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
	double winkelGier = ((double) unterschiedX) / this.as.breite;
	double winkelNick = -((double) unterschiedY) / this.as.hoehe;

	Dreimatrix giermatrix = Matrixdreher.machedrehery(winkelGier);
	Dreimatrix nickmatrix = Matrixdreher.machedreherx(winkelNick);

	this.as.basis = this.as.basis.punkt(giermatrix);
	this.as.basis = this.as.basis.punkt(nickmatrix);
	
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
