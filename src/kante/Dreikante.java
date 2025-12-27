package kante;

import punkt.Dreipunkt;

// Eine Dreikante ist ein Paar von zwei Dreipunkten.
//
// Die Idee ist, daß wir eine Dreikante eines Körpers beschreiben
// wollen. Obwohl die Daten dahin ganz einfach sind, ist es schwierig,
// die Datenstrukuren über einen Körper zu zeigen. Wir müssen ganz
// klar sein, daß ein Paar von Orten Teil eines Körpers ist.
public class Dreikante {
    public Dreipunkt von;
    public Dreipunkt bis;
    
    public Dreikante(Dreipunkt v, Dreipunkt b) {
	this.von = v;
	this.bis = b;
    }

    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(this.von.drucken());
	sb.append(" bis ");
	sb.append(this.bis.drucken());

	return sb.toString();
    }

    public void addieren(Dreipunkt p) {
	this.von.addieren(p);
	this.bis.addieren(p);
    }
}
