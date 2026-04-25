package wesen;

import vektor.Dreivektor;
import sicht.vielflach.Vielflachsicht;
import maler.Maler;

// Das Wesen nimmt den Verlauf der Zeit auf.
public class Vielflachbasiswesen implements Runnable {

    Maler m;
    Vielflachsicht vas;
    
    public Vielflachbasiswesen(Vielflachsicht vas, Maler m) {
	this.m = m;
	this.vas = vas;
    }

    public void run() {
	this.vas.entfernung.addiere(new Dreivektor(0, 0, 1));
	this.m.repaint();
    }
}
