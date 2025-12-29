package verleger.verschieben;

import java.util.ArrayList;
import punkt.Dreipunkt;
import welt.punktkoerper.Punktkoerperwelt;
import punktkoerper.Punktkoerper;

// Ein Zentrumverleger nimmt eine dreidimensionale Punktkörperwelt zu
// der gleichen Art, aber mit alle Punkten verschoben.
public class Verschiebenverleger {

    public Verschiebenverleger() {
	
    }

    // ein:
    // pkw: Punktkörperwelt
    // pv: Dreipunkt zum Verschieben
    // aus: 
    //
    // Verlegen die dreidimensionale Punktkörperwelt zu einer
    // zweidimensionale Zweikantewelt.
    //
    public void verlegenWelt(Punktkoerperwelt pkw,
			     Dreipunkt verschiebenpunkt) {

	ArrayList<Punktkoerper> pkl = pkw.punktkoerperliste;

	for (int i = 0; i < pkl.size(); i++) {
	    Punktkoerper pk = pkl.get(i);
	    Dreipunkt p = pk.punkt;
	    p.addieren(verschiebenpunkt);
	}
    }
}
