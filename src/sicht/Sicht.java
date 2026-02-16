package sicht;

import java.awt.Graphics;

// Im Allgemeinen ist eine Sicht ein Verfahren zum Anschauen einer
// Figur.
//
// Die Sicht ist immer zweidimensional. Die zur Sicht gegebenen Daten
// sind immer zweidimensional.
//
// Aber die ursprüngliche Daten können eindimensional,
// zweidimensional, dreidimensional, räumlich oder zeitlich sein.
//
// Die Sicht bildet die Daten nicht auf. Am besten umwandelt sie die
// ursprüngliche Daten nicht.  Eine Sicht soll so wenig Berechnungen
// wie möglich machen, sodaß sie die Welt darstellen kann.
//
// Die Sicht stellt Körper einer Welt dar, sodaß wir uns den Körpern
// auf einem Bildschirm anschauen können.
//
// Die Sicht kennt nicht, wie sie mit einem Mensch wechselwirken
// kann. Zum Beispiel mit der Mouse oder der Tastatur.
//
// Warum benutzen wir das JComponent nicht? Es gibt eine genaue
// Antwort: Java kann nicht eine Reihe von JComponenten
// zusammenketten, die aufeinander liegen. Deshalb müssen wir ein
// JComponent erzeugen, und eine reihe von "Sichten" benutzen.
public abstract class Sicht {
    public abstract void darstellen(Graphics g);
}
