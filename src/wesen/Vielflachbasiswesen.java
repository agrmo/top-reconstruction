package wesen;

import vektor.Dreivektor;
import sicht.vielflach.basis.Vielflachbasissicht;
import maler.Maler;
import dreher.vektor.Vektordreher;

// Das Wesen nimmt den Verlauf der Zeit auf.
public class Vielflachbasiswesen implements Runnable {

    Maler m;
    Vielflachbasissicht vbs;
    
    public Vielflachbasiswesen(Vielflachbasissicht vbs, Maler m) {
	this.m = m;
	this.vbs = vbs;
    }

    public void run() {
	// this.vbs.augevektor.addiere(new Dreivektor(0, 0, 1));

	Dreivektor dva = Vektordreher.drehenX(this.vbs.augevektor, 0.02);
	Dreivektor dvb = Vektordreher.drehenY(dva, 0.02);
	Dreivektor dvc = Vektordreher.drehenZ(dvb, 0.02);

	this.vbs.augevektor = dvc;
	this.m.repaint();
    }
}
