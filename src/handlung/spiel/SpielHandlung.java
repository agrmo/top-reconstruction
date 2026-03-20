package handlung.spiel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import spiel.Spiel;

// Eine SpielHandlung nimmt Ereignissen von einem Mensch, und gibt das
// Spiel den Befehl, etwas zu reagieren.
public class SpielHandlung implements MouseListener, MouseMotionListener, KeyListener {

    Spiel spiel;

    public SpielHandlung(Spiel s) {
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
	this.spiel.handelnMouse(e);
    }

    public void mouseMoved(MouseEvent e) {
	this.spiel.handelnMouseBewegen(e);
    }

    public void mouseDragged(MouseEvent e) {
	this.spiel.handelnMouseSchleifen(e);
    }

    public void keyTyped(KeyEvent e) {
	this.spiel.handelnTastatur(e);
    }
     
    public void keyPressed(KeyEvent e) {
	this.spiel.handelnTastaturDrucken(e);
    }
     
    public void keyReleased(KeyEvent e) {
	this.spiel.handelnTastaturLösen(e);
    }
}
