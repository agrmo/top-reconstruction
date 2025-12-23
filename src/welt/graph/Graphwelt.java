package welt.graph;

import graph.Nachbarschaftsliste;

/*
  Ein Koerper ist eine ganze Zahl.
  
  Ein Ort ist:
  - Verbindung von Koerper bis Paare von ganzen Zahlen
  
  Eine Graphwelt hat:
  - Liste von Orten
  
  Am Anfang ist ein Graph nicht darstellbar. Er besitzt viele Kanten
  und Knoten, die keinen bestimmten Ort besitzen.

  Eine Graphwelt verbindet einen Graph mit Orten der Knoten, sodaß wir
  ihn vorstellen können. Das tut man ohne Berechnungen, aber ein
  Computer ist kein Mensch.

  Wie stellte man die Orten eines Graphen? Die Knoten überliegen sich
  nicht. Die Kanten sind geradlinige. Die Kanten überliegen so wenig
  andere Kanten wie möglich. Und so weiter. Diese Grundlagen muss man
  rechnerich beitragen.

  Eine Graphwelt ist eine Welt des Graphen.
 */
public class Graphwelt {
    public int[][] orten;
    public Nachbarschaftsliste nachbarschaftsliste;

    public Graphwelt(Nachbarschaftsliste n, int[][] o) {
	orten = o;
	nachbarschaftsliste = n;
    }
}
