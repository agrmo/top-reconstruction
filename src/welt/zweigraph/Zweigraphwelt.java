package welt.zweigraph;

import graph.Nachbarschaftsliste;
import punkt.Zweipunkt;

/*
  Ein Koerper ist eine ganze Zahl.
  
  Ein Ort ist ein Paar von ganzen Zahlen.
  
  Eine Graphwelt ist ein Paar von:
  - Graph
  - Liste von Orten
  
  Am Anfang ist ein Graph nicht darstellbar. Er besitzt viele Strecken
  und Knoten, die keinen bestimmten Ort besitzen.

  Eine Graphwelt verbindet einen Graph mit Orten der Knoten, sodaß wir
  ihn vorstellen können. Das tut man ohne Berechnungen, aber ein
  Computer ist kein Mensch.

  Wie stellte man die Orten eines Graphen? Die Knoten überliegen sich
  nicht. Die Strecken sind geradlinige. Die Strecken überliegen so wenig
  andere Strecken wie möglich. Und so weiter. Diese Grundlagen muss man
  rechnerich beitragen.

  Eine Graphwelt ist eine Welt des Graphen.
 */
public class Zweigraphwelt {
    public Zweipunkt[] orten;
    public Nachbarschaftsliste nachbarschaftsliste;

    public Zweigraphwelt(Nachbarschaftsliste n, Zweipunkt[] o) {
	orten = o;
	nachbarschaftsliste = n;
    }
}
