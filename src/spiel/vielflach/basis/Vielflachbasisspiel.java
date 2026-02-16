package spiel.vielflach.basis;

import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.vielflach.basis.Vielflachbasissicht;
import spiel.Spiel;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;

public class Vielflachbasisspiel extends Spiel {

    Maler m;
    Vielflachbasissicht vbs;
    Vielflachwelt vw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Vielflachbasisspiel(Maler m,
			       Vielflachbasissicht vbs,
			       Vielflachwelt vw) {
	this.m = m;
	this.vbs = vbs;
	this.vw = vw;

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

	this.vbs.vorbasis = this.vbs.basis.punkt(this.vbs.vorbasis);
	this.vbs.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);

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
	double winkelGier = ((double) unterschiedX) / this.vbs.breite;
	double winkelNick = -((double) unterschiedY) / this.vbs.hoehe;

	Dreimatrix giermatrix = Matrixdreher.machedrehery(winkelGier);
	Dreimatrix nickmatrix = Matrixdreher.machedreherx(winkelNick);

	this.vbs.basis = this.vbs.basis.punkt(giermatrix);
	this.vbs.basis = this.vbs.basis.punkt(nickmatrix);
	
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
