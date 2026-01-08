package sicht;

import java.awt.Graphics;

// Im Allgemeinen ist eine Sicht ein Verfahren zum Anschauen einer
// Figur.
//
// Die Sicht ist immer zweidimensional. Die zur Sicht gegebene Daten
// sind immer zweidimensional.
//
// Aber die ursprüngliche Daten können eindimensional,
// zweidimensional, dreidimensional, räumlich oder zeitlich sein.
//
// Die Sicht bildet die Daten nicht auf. Am besten umwandelt sie die
// ursprüngliche Daten nicht.  Eine Sicht soll so wenig Berechnungen
// wie möglich machen, sodaß sie die Welt darstellen wird.
//
// Die Sicht stellt die Körper einer Welt dar, sodaß wir uns den
// Körpern auf einem Bildschirm anschauen können.
//
// Die Sicht kennt nicht, wie sie mit einem Mensch wechselwirken
// kann. Zum Beispiel mit der Mouse oder der Tastatur.
//
public abstract class Sicht {
    public abstract void darstellen(Graphics g);
}
