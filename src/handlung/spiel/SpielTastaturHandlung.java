package handlung.spiel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import spiel.Spiel;

// Eine SpielMouseHandlung nimmt Ereignissen von der Tastatur, und
// gibt das Spiel den Befehl, etwas zu reagieren.
public class SpielTastaturHandlung implements KeyListener {
    Spiel spiel;

    public SpielTastaturHandlung(Spiel s) {
	this.spiel = s;
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
