package kante;

import punkt.Punkt;
import java.util.Arrays;

// Eine Kante ist ein Paar von zwei Punkten.
//
// Die Idee ist, daß wir eine Kante eines Körpers beschreiben
// wollen. Obwohl die Daten dahin ganz einfach sind, ist es schwierig,
// die Datenstrukuren über einen Körper zu zeigen. Wir müssen ganz
// klar sein, daß ein Paar von Orten Teil eines Körpers ist.
public class Kante {
    public Punkt von;
    public Punkt bis;
    
    public Kante(Punkt v, Punkt b) {
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
}
