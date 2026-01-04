package sicht.figur;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import kante.Zweikante;
import welt.figur.Figurwelt;

// Die Figursicht zeigt insbesondere nur die erste und zweite Teile
// der Figur. Sie ist einer der einfachsten Methoden, einen Figur
// darzustellen.
public class Figursicht extends JComponent {

    public Figurwelt fw;

    public Figursicht(Figurwelt fw) {
	this.fw = fw;
    }

    // Wir müssen entscheiden, wer diese Figur darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Nehme die Zweikanten dieser Welt.
	ArrayList<Zweikante> wk = this.fw.nehmeKanten();

	for (int i = 0; i < wk.size(); i++) {
	    g.drawLine((int) wk.get(i).von.xteil, (int) wk.get(i).von.yteil,
		       (int) wk.get(i).bis.xteil, (int) wk.get(i).bis.yteil);
	}
    }
}

