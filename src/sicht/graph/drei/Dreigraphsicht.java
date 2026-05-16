package sicht.graph.drei;

import auge.Auge;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.Sicht;
import sicht.graph.zwei.Zweigraphsicht;
import verleger.graph.Dreigraphverleger;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;

// Eine Sicht, die eine dreidimensionale Graphwelt darstellt.
public class Dreigraphsicht extends Sicht {

    // Die Welt.
    public Dreigraphwelt dgw;

    // Jeder Knoten ist als einen Kreis dargestellt.
    double durchmesser;

    // Das Auge.
    Auge auge;
    
    public Dreigraphsicht(Dreigraphwelt dgw, double durchmesser, Auge auge) {
	this.dgw = dgw;
	this.durchmesser = durchmesser;
	this.auge = auge;
    }
    
    public void darstellen(Graphics g) {

	// Wandle eine Dreigraphsicht zu einer Zweigraphsicht um.  Wir
	// müssen nur die dreidimensionalen Stellen zu
	// zweidimensionalen verlegen. Die Verbindungen der Knoten
	// werden nicht verändert.
	Zweigraphwelt zgw = Dreigraphverleger.verlege(this.dgw, this.auge);

	// Die Zweigraphsicht wird die Knoten richtig verschieben,
	// sodaß jeweilige Kante in das Zentrum des Knoten gesetzt
	// wird. Interessant, daß das in nur zwei Dimensionen gilt.
	Zweigraphsicht zs = new Zweigraphsicht(zgw, this.durchmesser);
	zs.darstellen(g);
    }
}
