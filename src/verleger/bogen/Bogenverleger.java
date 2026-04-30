package verleger.dreibogen;

import dreher.euler.Eulerdreher;

// Verlegt einen dreidimensionalen Bogen auf einer zweidimensionalen
// Fläche.
public class Bogenverleger {

    // Verlege den gegebenen Bogen.
    // 1. Nehme an, daß der Bogen am Anfang in der x-y-Fläche steht.
    // 2. Die gegebene Orientierung dreht den Bogen von der x-y-Fläche.
    // public Bogen verlege(Dreibogen db, Orientierung s) {

    // 	Dreivektor anfangx = new Dreivektor(1,0,0);
    // 	Dreivektor anfangy = new Dreivektor(0,1,0);

    // 	Dreimatrix drehung = Eulerdreher.nehmedrehung(s.winkeleins,
    // 						      s.winkelzwei,
    // 						      s.winkeldrei);

    // 	Dreivektor endx = drehung.punkt(anfangx);
    // 	Dreivektor endy = drehung.punkt(anfangy);

    // 	// Nehme den x-Teil von endx.

    // 	// Nehme den y-Teil von endy.

    // 	// Bogen zb = new Bogen(zb, zh, zaw, zuw);
    // }
}
