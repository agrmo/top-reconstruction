package handlung;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// Die Handlung ist ein Verfahren zur Wechselwirkung zwischen Mensch
// und Computer. Insbesondere versuchen wir die Mouse und Tastatur zum
// Code verbinden, sodaß wir in einer Welt laufen können.
//
// In Java müssen wir KeyListener, MouseListener und
// MouseMotionListener benutzen.
//
// Eine Handlung enthält eine Sicht. Die Handlung gibt der Sicht den
// Befehl, wieder darzustellen.
public class Handlung implements MouseListener, MouseMotionListener, KeyListener {
    public void mouseEntered(MouseEvent me) {
	// nichts
    }

    public void mouseExited(MouseEvent me) {
	// nichts
    }

    public void mouseClicked(MouseEvent me) {
	// nichts
    }

    public void mouseMoved(MouseEvent me) {
	// nichts
    }
    
    public void mousePressed(MouseEvent me) {
	// nichts
    }
    
    public void mouseReleased(MouseEvent me) {
	// nichts
    }
        
    public void mouseDragged(MouseEvent me) {
	// nichts
    }
    
    public void keyTyped(KeyEvent ke) {
	// nichts
    }

    public void keyPressed(KeyEvent ke) {
	// nichts
    }

    public void keyReleased(KeyEvent ke) {
	// nichts
    }
}
