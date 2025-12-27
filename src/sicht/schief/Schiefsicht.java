package sicht.schief;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import welt.punktkoerper.Punktkoerperwelt;
import vektor.Dreivektor;
import kante.Dreikante;
import punkt.Dreipunkt;

// Schon ist die Schiefsicht eine Welt gegeben. Die gegebene Welt
// enthält alle Körper und ihre befindenden Stellen. Die Schiefsicht
// darf nur ausrechnen, wie die Körper aussehen. Dafür muss sie die
// Dreikanten eines Kubus gut berechnen, und so weiter.
public class Schiefsicht extends JComponent {

    public Dreivektor d;
    public int mu;
    public Punktkoerperwelt pkw;

    // ein: Dreivektor, ganze Zahl
    //
    // Zeigt die Ausbreitungsgröße. Zeigt wie groß das Bild ausdehnen
    // werden im Unterschied mit dem ursprunglichen Stellen.
    // 
    // Wir nehmen an, daß die Sichtfläche genau auf der z=0 Fläche
    // stehen. Ich konnte dei Fläche bestimmbar machen.
    public Schiefsicht(Dreivektor d, int mu, Punktkoerperwelt pkw) {
	this.d = d;
	this.mu = mu;
	this.pkw = pkw;
    }

    // Verlegen den gegeben Dreipunkt auf dieser Sichtfläche.
    public int[] verlegen(Dreipunkt p) {
	int ausX = p.eins - ((this.d.eins / this.d.drei) * p.drei);
	int ausY = p.zwei - ((this.d.zwei / this.d.drei) * p.drei);
	int[] aus = new int[] {ausX, ausY};
	
	return aus;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Nehme die Dreikanten dieser Welt.
	ArrayList<Dreikante> wk = this.pkw.nehmeKanten();

	g.setColor(Color.BLACK);
	
	for (int i = 0; i < wk.size(); i++) {
	    
	    int[] verlegterDreipunktVon = this.verlegen(wk.get(i).von);
	    int[] verlegterDreipunktBis = this.verlegen(wk.get(i).bis);
	    
	    g.drawLine(verlegterDreipunktVon[0], verlegterDreipunktVon[1],
		       verlegterDreipunktBis[0], verlegterDreipunktBis[1]);
	}
    }
}

