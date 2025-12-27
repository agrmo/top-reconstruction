package sicht.parallel;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import welt.punktkoerper.Punktkoerperwelt;
import vektor.Dreivektor;
import kante.Dreikante;

// Schon ist die Parallelsicht eine Welt gegeben. Die gegebene Welt
// enthält alle Körper und ihre befindenden Stellen. Die Parallelsicht
// darf nur ausrechnen, wie die Körper aussehen. Dafür muss sie die
// Dreikanten eines Kubus gut berechnen, und so weiter.
public class Parallelsicht extends JComponent {

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
    public Parallelsicht(Dreivektor d, int mu, Punktkoerperwelt pkw) {
	this.d = d;
	this.mu = mu;
	this.pkw = pkw;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Nehme die Dreikanten dieser Welt.
	ArrayList<Dreikante> wk = this.pkw.nehmeKanten();

	g.setColor(Color.BLACK);
	
	for (int i = 0; i < wk.size(); i++) {
	    System.out.println(wk.get(i).drucken());
	    g.drawLine(wk.get(i).von.eins, wk.get(i).von.zwei,
		       wk.get(i).bis.eins, wk.get(i).bis.zwei);
	}
    }
}

