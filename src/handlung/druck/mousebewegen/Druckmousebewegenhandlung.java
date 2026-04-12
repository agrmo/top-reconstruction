package handlung.druck.mousebewegen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

// Nur zu drucken.
public class Druckmousebewegenhandlung implements MouseMotionListener {

    public void mouseDragged(MouseEvent e) {
	System.out.println("Mouse schleifen auf " + e.getX() + " " + e.getY());
    }

    public void mouseMoved(MouseEvent e) {
	System.out.println("Mouse bewegt auf " + e.getX() + " " + e.getY());
    }
}
