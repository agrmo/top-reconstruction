package spiel.nichts;

import spiel.Spiel;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// Ein Spiel, das nichts tut.
public class Nichtsspiel extends Spiel {

    public Nichtsspiel() {
	
    }

    void nichts() {
	System.out.println("Ich tue nichts.");
    }

    public void handelnMouseDrucken(MouseEvent me) {
	nichts();
	
    }
    
    public void handelnMouseLösen(MouseEvent me) {
	nichts();
	
    }
    
    public void handelnMouseEin(MouseEvent me) {
	nichts();
	
    }
    
    public void handelnMouseAus(MouseEvent me) {
	nichts();
	
    }
    
    public void handelnMouse(MouseEvent me) {
	nichts();
	
    }
    
    public void handelnTastatur(KeyEvent ke) {
	nichts();
	
    }
    
    public void handelnTastaturDrucken(KeyEvent ke) {
	nichts();
	
    }
    
    public void handelnTastaturLösen(KeyEvent ke) {
	nichts();
    }
}
