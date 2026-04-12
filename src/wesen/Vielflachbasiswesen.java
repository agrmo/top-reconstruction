package wesen;

import vektor.Dreivektor;
import sicht.vielflach.auge.Augesicht;
import maler.Maler;
import dreher.vektor.Vektordreher;

// Das Wesen nimmt den Verlauf der Zeit auf.
public class Vielflachbasiswesen implements Runnable {

    Maler m;
    Augesicht vas;
    
    public Vielflachbasiswesen(Augesicht vas, Maler m) {
	this.m = m;
	this.vas = vas;
    }

    public void run() {
	this.vas.entfernung.addiere(new Dreivektor(0, 0, 1));
	this.m.repaint();
    }
}
