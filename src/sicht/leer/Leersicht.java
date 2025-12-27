package sicht.leer;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

// Eine Sicht ohne etwas zu sehen.
public class Leersicht extends JComponent {
    
    public Leersicht() {
	
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
    }
}
