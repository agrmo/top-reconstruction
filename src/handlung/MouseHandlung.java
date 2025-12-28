package handlung;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class MouseHandlung implements MouseListener {

    public void mousePressed(MouseEvent e) {
	drucken("Mouse pressed; # of clicks: "
		     + e.getClickCount(), e);
    }

    public void mouseReleased(MouseEvent e) {
	drucken("Mouse released; # of clicks: "
		     + e.getClickCount(), e);
    }

    public void mouseEntered(MouseEvent e) {
	drucken("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
	drucken("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
	drucken("Mouse clicked (# of clicks: "
		     + e.getClickCount() + ")", e);
    }

    void drucken(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
			   + e.getComponent().getClass().getName()
			   + "." + "\n");
    }
}
