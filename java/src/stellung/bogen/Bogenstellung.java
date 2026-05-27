package stellung.bogen;

import dreher.euler.Eulerdreher;
import matrix.Dreimatrix;
import vektor.Dreivektor;
import strecke.Dreistrecke;
import stellung.Dreistellung;
import bogen.Bogen;

/*
  Schlechter Name, aber klarer Algorithmus.

  Ein Bogen hängt mit seinem Ort und seiner Orientierung zusammen.

  Um den Bogen in einer dreidimensionalen Welt zu stellen, brauchen
  wir die folgenden Schritte:
  
  1. Nehme die zweidimensionalen Kanten des Bogenes
  2. Erweitern die Koordinaten zu drei Dimensionen (d.h. z=0)
  2. Drehen mit Hilfe der Orientierung
  3. Versciebe den Bogen zu seinem Ort

  Das heißt das Stellen: Stelle den Bogen an seinem Ort und mit
  seiner Orientierung.

  Aber wie drehen wir einen Bogen in drei Dimensionen? Die
  ursprüngliche Winkel des Bogens gelten nur in zwei Dimensionen.
*/
public class Bogenstellung {

    // public static Dreistrecke[] stelle(Bogen v, Dreistellung s) {
	
    // }
}
