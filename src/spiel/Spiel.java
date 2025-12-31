package spiel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// Ein Spiel ist die Zusammenklebung von einer Sicht und einer
// Handlung.
//
// Das Spiel und auch die Handlung enthalten die Sicht. Das Spiel
// fängt an, die Sicht darzustellen. Die Handlung gibt manchmal noch
// mal der Sicht den Befehl, wieder darzustellen.
public abstract class Spiel {
    public abstract void handelnMouseEin(MouseEvent me);
    public abstract void handelnMouseAus(MouseEvent me);
    public abstract void handelnMouseDrucken(MouseEvent me);
    public abstract void handelnMouseLösen(MouseEvent me);
    public abstract void handelnMouse(MouseEvent me);

    public abstract void handelnMouseBewegen(MouseEvent me);
    public abstract void handelnMouseSchleifen(MouseEvent me);
    
    public abstract void handelnTastatur(KeyEvent ke);
    public abstract void handelnTastaturDrucken(KeyEvent ke);
    public abstract void handelnTastaturLösen(KeyEvent ke);
}
