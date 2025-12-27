package sicht.parallel;

// import welt.euklid.Punktkoerperwelt;
import java.util.ArrayList;
// import vektor.Vektor;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

// g.drawLine()

/*  
  Schon ist die Parallelsicht eine Welt gegeben. Die gegebene Welt
  enthält alle Körper und ihre befindenden Stellen. Die Parallelsicht
  darf nur ausrechnen, wie die Körper aussehen. Dafür muss sie die
  Kanten eines Kubus gut berechnen, und so weiter.
 */
public class Parallelsicht extends JComponent {

    // public Vektor d;
    // public int mu;
    // public Punktkoerperwelt vw;

    // Ein:
    // d, Vektor, Eine Sichtvektor
    // mu, ganze Zahl
    //
    // Zeigt die Ausbreitungsgröße. Zeigt wie groß das Bild ausdehnen
    // werden im Unterschied mit dem ursprunglichen Stellen.
    // 
    // Wir nehmen an, daß die Sichtfläche genau auf der z=0 Fläche
    // stehen. Ich konnte dei Fläche bestimmbar machen.
    // public Parallelsicht(Vektor d, int mu, Punktkoerperwelt vw) {
	
    // }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
    }
}

