package wesen;

import vektor.Dreivektor;
import sicht.vielflach.basis.Vielflachbasissicht;
import maler.Maler;

// Das Wesen nimmt den Verlauf der Zeit auf.
public class Vielflachbasiswesen implements Runnable {

    Maler m;
    Vielflachbasissicht vbs;
    
    public Vielflachbasiswesen(Vielflachbasissicht vbs, Maler m) {
	this.m = m;
	this.vbs = vbs;
    }

    public void run() {
	this.vbs.augevektor.addiere(new Dreivektor(0, 0, 1));
	this.m.repaint();
    }
}
