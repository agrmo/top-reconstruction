package spiel.graph;

import dreher.matrix.Matrixdreher;
import dreher.vektor.Vektordreher;
import druck.matrix.Matrixdrucker;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import maler.Maler;
import matrix.Dreimatrix;
import sicht.graph.drei.Dreigraphaugesicht;
import spiel.Spiel;
import vektor.Dreivektor;
import welt.graph.Dreigraphwelt;

// Ein Spiel, das einen dreidimensionalen Graph darstellt.
public class Graphspiel extends Spiel {

    Maler m;
    Dreigraphaugesicht ds;
    Dreigraphwelt dgw;
    int mousevorx;
    int mousevory;

    public Graphspiel(Maler m,
		      Dreigraphaugesicht ds,
		      Dreigraphwelt dgw) {
	this.m = m;
	this.ds = ds;
	this.dgw = dgw;

	this.mousevorx = 0;
	this.mousevory = 0;
    }
    
    public void handelnMouseDrucken(MouseEvent me) {
	this.mousevorx = me.getX();
	this.mousevory = me.getY();
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	this.mousevorx = 0;
	this.mousevory = 0;

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
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedX = jetztx - this.mousevorx;
	int unterschiedY = jetzty - this.mousevory;
	double winkelgier = ((double) unterschiedX) / this.ds.breite;
	double winkelnick = -((double) unterschiedY) / this.ds.hoehe;

	Dreimatrix giermatrix = Matrixdreher.nehmedrehery(winkelgier);
	Dreimatrix nickmatrix = Matrixdreher.nehmedreherx(winkelnick);

	// Richtig...?
	this.ds.augevektor = giermatrix.punkt(this.ds.augevektor);
	this.ds.augevektor = nickmatrix.punkt(this.ds.augevektor);
	
	this.mousevorx = jetztx;
	this.mousevory = jetzty;

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
