package kante;

import punkt.Zweipunkt;

// Eine Zweikante ist ein Paar von zwei Zweipunkten.
//
// Eine Zweikante ist eine zweidimensionale Kante.
//
// Die Idee ist, daß wir eine Zweikante eines Körpers beschreiben
// wollen. Obwohl die Daten dahin ganz einfach sind, ist es schwierig,
// die Datenstrukuren über einen Körper zu zeigen. Wir müssen ganz
// klar sein, daß ein Paar von Orten Teil eines Körpers ist.
public class Zweikante {
    public Zweipunkt von;
    public Zweipunkt bis;
    
    public Zweikante(Zweipunkt v, Zweipunkt b) {
	this.von = v;
	this.bis = b;
    }

    public void addieren(Zweipunkt p) {
	this.von.addieren(p);
	this.bis.addieren(p);
    }
}
