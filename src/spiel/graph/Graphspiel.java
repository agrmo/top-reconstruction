package spiel.graph;

import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.graph.drei.Dreigraphbasissicht;
import spiel.Spiel;
import vektor.Dreivektor;
import welt.graph.Dreigraphwelt;

// Ein Spiel, das einen dreidimensionalen Graph darstellt.
public class Graphspiel extends Spiel {

    Maler m;
    Dreigraphbasissicht ds;
    Dreigraphwelt dgw;
    int mouseAnfangX;
    int mouseAnfangY;

    public Graphspiel(Maler m,
		      Dreigraphbasissicht ds,
		      Dreigraphwelt dgw) {
	this.m = m;
	this.ds = ds;
	this.dgw = dgw;

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

	this.ds.vorbasis = this.ds.basis.punkt(this.ds.vorbasis);
	this.ds.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
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
	double winkelGier = ((double) unterschiedX) / this.ds.breite;
	double winkelNick = -((double) unterschiedY) / this.ds.hoehe;

	Dreimatrix giermatrix = Matrixdreher.machedrehery(winkelGier);
	Dreimatrix nickmatrix = Matrixdreher.machedreherx(winkelNick);

	this.ds.basis = this.ds.basis.punkt(giermatrix);
	this.ds.basis = this.ds.basis.punkt(nickmatrix);
	
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
