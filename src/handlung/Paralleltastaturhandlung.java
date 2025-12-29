package handlung;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sicht.parallel.Parallelsicht;

// Nur zu drucken.
public class Paralleltastaturhandlung extends Handlung implements KeyListener {

    Parallelsicht parallelsicht;

    public Paralleltastaturhandlung(Parallelsicht ps) {
	this.parallelsicht = ps;
    }
     
    public void keyPressed(KeyEvent e) {
	// Tue nichts.
    }
     
    public void keyReleased(KeyEvent e) {
        // Tue nichts.
    }

    // Eine Taste ist für diese Parallelsicht getastet. Eine
    // Parallelsicht enthält keinen Verleger. Alle die Daten liegen
    // genau in den ursprünglichen Daten, das ist die
    // Punktkörperwelt. Leider können wir die ursprüngliche Daten
    // einer Punktkörperwelt verändern, weil ein Punktkörper keine
    // allgemeine Funktionen besitzt. (Gibt es einen anderen Weg?)
    public void keyTyped(KeyEvent e) {
	int id = e.getID();
	
        if (id == KeyEvent.KEY_TYPED) {
            char kc = e.getKeyChar();

	    if (kc == 'w') {
		System.out.println('w' + " getastet");
		
	    } else if (kc == 's') {
		System.out.println('s' + " getastet");
		
	    } else if (kc == 'a') {
		System.out.println('a' + " getastet");
		
	    } else if (kc == 'd') {
		System.out.println('d' + " getastet");
		
	    }
        }
    }     
}
