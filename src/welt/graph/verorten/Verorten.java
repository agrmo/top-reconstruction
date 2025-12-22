package welt.graph.verorten;

import graph.Nachbarschaftsliste;

/*
  Wie können wir die Orten eines Graphen bestimmen, wenn am Anfang es
  keine Orten gibt? Nehmen wir eine Menge von Grundlagen an, mit denen
  wir die Orten berechnen werden.
 */  
public interface Verorten {
    public int[][] verorten(Nachbarschaftsliste nl);
}
