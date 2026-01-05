package sicht.graph;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import welt.graph.Graphwelt;
import punkt.Zweipunkt;

// Ein Bild ist eine zweidimensionale Darstellung von etwas.  Wir
// können es unmittelbar zu Java eintragen, um zu darstellen.  Unser
// Sicht stellt uns einen Graph dar.  Ihre Beobachtung der Welt
// erfolgt unabhängig vom Zeitverlauf derer.
public class Graphsicht extends JComponent {
    
    public Graphwelt gw;
    
    // Nehme an, wie groß ein Knoten ist.
    int groese = 20;
    
    public Graphsicht(Graphwelt g) {
	gw = g;
    }

    // Stelle den i-ten Knoten dar.
    void darstellenKnoten(Graphics g, int i) {
	int knotenx = (int) this.gw.orten[i].xteil;
	int knoteny = (int) this.gw.orten[i].yteil;
	
	g.fillOval(knotenx, knoteny, this.groese, this.groese);
    }

    // Stelle alle die zu dem i-ten Knoten verbundenen Kanten dar.
    void darstellenKante(Graphics g, int i) {

	// Wir brauchen nicht eine verdoppelte Nachbarschaftsliste.
	
	// Wo dieser Knoten ist.
	int vonX = (int) this.gw.orten[i].xteil;
	int vonY = (int) this.gw.orten[i].yteil;

	for (int j = 0; j < this.gw.nachbarschaftsliste.n.get(i).size(); j++) {

	    // Wer der Knoten ist, dem dieser Knoten verbunden ist.
	    int bisKnoten = this.gw.nachbarschaftsliste.n.get(i).get(j);
		    
	    int bisX = (int) this.gw.orten[bisKnoten].xteil;
	    int bisY = (int) this.gw.orten[bisKnoten].yteil;
		
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
