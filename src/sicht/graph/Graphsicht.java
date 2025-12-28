package sicht.graph;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import welt.graph.Graphwelt;

// Ein Bild ist eine zweidimensionale Darstellung von etwas.
// Wir können es unmittelbar zu Java eintragen, um zu darstellen.

// Unser Sicht stellt uns einen Graph dar.
  
// Ihre Beobachtung der Welt erfolgt unabhängig vom Zeitverlauf derer.
public class Graphsicht extends JComponent {
    
    public Graphwelt gw;
    
    // Nehme an, wie groß ein Knoten ist.
    int groese = 20;
    
    public Graphsicht(Graphwelt g) {
	gw = g;
    }

    // Darstelle den i-ten Knoten.
    void darstellenKnoten(Graphics g, int i) {
	g.fillOval(this.gw.orten[i][0], this.gw.orten[i][1], this.groese, this.groese);
    }

    // Darstelle alle die zu dem i-ten Knoten verbundenen Kanten.
    void darstellenKante(Graphics g, int i) {

	// Wir brauchen nicht eine verdoppelte Nachbarschaftsliste.
	
	// Wo dieser Knoten ist.
	int vonX = this.gw.orten[i][0];
	int vonY = this.gw.orten[i][1];

	for (int j = 0; j < this.gw.nachbarschaftsliste.n.get(i).size(); j++) {

	    // Wer der Knoten ist, dem dieser Knoten verbunden ist.
	    int bisKnoten = this.gw.nachbarschaftsliste.n.get(i).get(j);
		    
	    int bisX = this.gw.orten[bisKnoten][0];
	    int bisY = this.gw.orten[bisKnoten][1];
		
	    g.drawLine(vonX, vonY, bisX, bisY);
	}
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle die Knoten dar.
	for (int i = 0; i < this.gw.nachbarschaftsliste.betrag; i++) {
	    darstellenKnoten(g, i);
	}

	// Stelle die Kanten dar.
	for (int i = 0; i < this.gw.nachbarschaftsliste.betrag; i++) {
	    darstellenKante(g, i);
	}
    }

}
