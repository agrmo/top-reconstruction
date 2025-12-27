package sicht.schief;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import welt.punktkoerper.Punktkoerperwelt;
import vektor.Vektor;
import kante.Kante;
import punkt.Punkt;

// Schon ist die Schiefsicht eine Welt gegeben. Die gegebene Welt
// enthält alle Körper und ihre befindenden Stellen. Die Schiefsicht
// darf nur ausrechnen, wie die Körper aussehen. Dafür muss sie die
// Kanten eines Kubus gut berechnen, und so weiter.
public class Schiefsicht extends JComponent {

    public Vektor d;
    public int mu;
    public Punktkoerperwelt pkw;

    // Ein:
    // d, Vektor, Eine Sichtvektor
    // mu, ganze Zahl
    //
    // Zeigt die Ausbreitungsgröße. Zeigt wie groß das Bild ausdehnen
    // werden im Unterschied mit dem ursprunglichen Stellen.
    // 
    // Wir nehmen an, daß die Sichtfläche genau auf der z=0 Fläche
    // stehen. Ich konnte dei Fläche bestimmbar machen.
    public Schiefsicht(Vektor d, int mu, Punktkoerperwelt pkw) {
	this.d = d;
	this.mu = mu;
	this.pkw = pkw;
    }

    // Verlegen den gegeben Punkt auf dieser Sichtfläche.
    public int[] verlegen(Punkt p) {
	int ausX = p.eins - ((this.d.eins / this.d.drei) * p.drei);
	int ausY = p.zwei - ((this.d.zwei / this.d.drei) * p.drei);
	int[] aus = new int[] {ausX, ausY};
	
	return aus;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Nehme die Kanten dieser Welt.
	ArrayList<Kante> wk = this.pkw.nehmeKanten();

	g.setColor(Color.BLACK);
	
	for (int i = 0; i < wk.size(); i++) {
	    
	    int[] verlegterPunktVon = this.verlegen(wk.get(i).von);
	    int[] verlegterPunktBis = this.verlegen(wk.get(i).bis);
	    
	    g.drawLine(verlegterPunktVon[0], verlegterPunktVon[1],
		       verlegterPunktBis[0], verlegterPunktBis[1]);
	}
    }
}

