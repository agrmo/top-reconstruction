package handlung.spiel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import spiel.Spiel;

// Eine SpielMouseHandlung nimmt Ereignissen von der Mouse, und gibt
// das Spiel den Befehl, etwas zu reagieren.
public class SpielMouseHandlung implements MouseListener {

    Spiel spiel;

    public SpielMouseHandlung(Spiel s) {
	this.spiel = s;
    }

    public void mousePressed(MouseEvent e) {
	this.spiel.handelnMouseDrucken(e);
    }

    public void mouseReleased(MouseEvent e) {
	this.spiel.handelnMouseLösen(e);
    }

    public void mouseEntered(MouseEvent e) {
	this.spiel.handelnMouseEin(e);	
    }

    public void mouseExited(MouseEvent e) {
	this.spiel.handelnMouseAus(e);		
    }

    public void mouseClicked(MouseEvent e) {
	spiel.handelnMouse(e);
    }
}
