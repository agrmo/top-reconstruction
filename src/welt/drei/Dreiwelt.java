package welt.drei;
    
import java.util.ArrayList;
import koerper.Koerper;
import strecke.Dreistrecke;
import vektor.Dreivektor;
import punkt.Dreipunkt;
import figur.Figur;
import strecke.Zweistrecke;

// Eine Dreiwelt enthält ein-, zwei- und dreidimensionale
// Dingen. D.h. Punkten, Figuren und Körper.  Sie enthält keine Farbe.
// Die Punkten, Figuren und Körper stehen in ihre eigene Listen. 
public class Dreiwelt {

    // Diese Welt enthält Punkten, Strecken, Figuren und Körpern.
    public Dreipunkt[] punktliste;
    public Dreistrecke[] streckeliste;
    public Figur[] figurliste;
    public Koerper[] koerperliste;

    // Die Figuren und Körper müssen einen Ort besitzen.
    public Dreipunkt[] figurorten;
    public Dreipunkt[] koerperorten;

    // Die Figuren und Körper müssen eine Ausrichtung besitzen.
    public Dreivektor[] figurausrichtungen;
    public Dreivektor[] koerperausrichtungen;

    public Dreiwelt(Dreipunkt[] pl, Dreistrecke[] sl, Koerper[] kl) {
 	this.punktliste = pl;
	this.streckeliste = sl;
	this.koerperliste = kl;
    }

    // public Dreipunkt[] nehmePunkten() {
	
    // }

    // public Zweistrecke[] nehmekanten() {
	
    // }
}
