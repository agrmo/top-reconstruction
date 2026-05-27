package stellung.vielflach;

import dreher.euler.Eulerdreher;
import matrix.Dreimatrix;
import vektor.Dreivektor;
import strecke.Dreistrecke;
import stellung.Dreistellung;
import vielflach.Vielflach;

/*
  Schlechter Name, aber klarer Algorithmus.

  Ein Vielflach hängt mit seinem Ort und seiner Orientierung zusammen.

  Um den Vielflach in einer Welt zu stellen, brauchen wir die folgenden
  Schritte:
  1. Nehme die dreidimensionalen Kanten des Vielflaches
  2. Drehen mit Hilfe der Orientierung den Körper
  3. Versciebe den Vielflach zu seinem Ort

  Das heißt das Stellen: Stelle den Vielflach an seinem Ort und mit
  seiner Orientierung.
 */
public class Vielflachstellung {

    public static Dreistrecke[] stelle(Vielflach v, Dreistellung s) {

	// 1.
	Dreistrecke[] dreikante = v.nehmekanten();
	Dreimatrix drehung = Eulerdreher.nehmedrehung(s.orientierung.winkeleins,
						      s.orientierung.winkelzwei,
						      s.orientierung.winkeldrei);

	for (int i = 0; i < dreikante.length; i++) {

	    // 2.
	    dreikante[i].von = drehung.punkt(dreikante[i].von);
	    dreikante[i].bis = drehung.punkt(dreikante[i].bis);

	    // 3.
	    dreikante[i].von.addiere(s.ort);
	    dreikante[i].bis.addiere(s.ort);
	}

	return dreikante;
    }
}
