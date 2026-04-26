package wesen;

import vektor.Dreivektor;
import sicht.vielflach.Vielflachsicht;
import maler.Maler;

// Das Wesen nimmt den Verlauf der Zeit auf.
public class Vielflachbasiswesen implements Runnable {

    Maler m;
    Vielflachsicht vs;
    
    public Vielflachbasiswesen(Vielflachsicht vs, Maler m) {
	this.m = m;
	this.vs = vs;
    }

    public void run() {
	this.vs.entfernung.addiere(new Dreivektor(0, 0, 1));
	this.m.repaint();
    }
}
