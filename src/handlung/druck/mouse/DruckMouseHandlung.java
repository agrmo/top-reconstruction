package handlung.druck.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Nur zu drucken.
public class DruckMouseHandlung implements MouseListener {

    public void mousePressed(MouseEvent e) {
	drucke("Mouse gedruckt (# von Berührungen: "
		     + e.getClickCount() + ")", e);
    }

    public void mouseReleased(MouseEvent e) {
	drucke("Mouse gelöst (# von Berührungen: "
		     + e.getClickCount() + ")", e);
    }

    public void mouseEntered(MouseEvent e) {
	drucke("Mouse eingegangen", e);
    }

    public void mouseExited(MouseEvent e) {
	drucke("Mouse ausgegangen", e);
    }

    public void mouseClicked(MouseEvent e) {
	drucke("Mouse getastet (# von Berührungen: "
		     + e.getClickCount() + ")", e);
    }

    void drucke(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " von "
			   + e.getComponent().getClass().getName()
			   + "." + "\n");
    }
}
