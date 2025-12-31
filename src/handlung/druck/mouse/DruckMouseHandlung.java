package handlung.druck.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Nur zu drucken.
public class DruckMouseHandlung implements MouseListener {

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

    void drucken(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " von "
			   + e.getComponent().getClass().getName()
			   + "." + "\n");
    }
}
