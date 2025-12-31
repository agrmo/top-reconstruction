package handlung.druck.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// Nur zu drucken.
public class DruckMouseHandlung implements MouseListener, MouseMotionListener {

    public void mousePressed(MouseEvent e) {
	drucken("Mouse gedruckt (# von Berührungen: "
		     + e.getClickCount() + ")", e);
    }

    public void mouseReleased(MouseEvent e) {
	drucken("Mouse gelöst (# von Berührungen: "
		     + e.getClickCount() + ")", e);
    }

    public void mouseEntered(MouseEvent e) {
	drucken("Mouse eingegangen", e);
    }

    public void mouseExited(MouseEvent e) {
	drucken("Mouse ausgegangen", e);
    }

    public void mouseClicked(MouseEvent e) {
	drucken("Mouse getastet (# von Berührungen: "
		     + e.getClickCount() + ")", e);
    }

    public void mouseDragged(MouseEvent e) {
	System.out.println("Mouse geschliffen auf " + e.getX() + " " + e.getY());
    }

    public void mouseMoved(MouseEvent e) {
	System.out.println("Mouse bewegt auf " + e.getX() + " " + e.getY());
    }

    void drucken(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " von "
			   + e.getComponent().getClass().getName()
			   + "." + "\n");
    }
}
