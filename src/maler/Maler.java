package maler;

import javax.swing.JComponent;
import java.awt.Graphics;
import sicht.Sicht;

// Java hat die Fähigkeit nicht, eine Reihe von JComponenten
// darzustellen. Darum müssen wir genau ein JComponent erzeugen und
// dahin eine Reihe von paintComponent() aufrufen. Es gibt immer nur
// ein Maler. Er mält eine Liste von Kunstwerken auf der Tafel.
public class Maler extends JComponent {

    public Sicht[] sichte;

    public Maler(Sicht[] s) {
	this.sichte = s;
    }

    public void paintComponent(Graphics g) {
	for (int i = 0; i < this.sichte.length; i++) {
	    this.sichte[i].darstellen(g);
	}
    }
}
