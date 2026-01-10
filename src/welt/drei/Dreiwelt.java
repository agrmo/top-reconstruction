package welt.drei;
    
import punkt.Dreipunkt;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vieleck.Vieleck;
import vielflach.Vielflach;

// Eine Dreiwelt enthält ein-, zwei- und dreidimensionale
// Dingen. D.h. Punkten, Vielecken und Körper.  Sie enthält keine Farbe.
// Die Punkten, Vielecken und Körper stehen in ihre eigene Listen. 
public class Dreiwelt {

    // Diese Welt enthält Punkten, Strecken, Vielecken und Körpern.
    public Dreipunkt[] punktliste;
    public Dreistrecke[] streckeliste;
    public Vieleck[] vieleckliste;
    public Vielflach[] vielflachliste;

    // Die Vielecken und Körper müssen einen Ort besitzen.
    public Dreipunkt[] vieleckorten;
    public Dreipunkt[] vielflachorten;

    // Die Vielecken und Körper müssen eine Ausrichtung besitzen.
    public Dreivektor[] vieleckausrichtungen;
    public Dreivektor[] vielflachausrichtungen;

    public Dreiwelt(Dreipunkt[] pl, Dreistrecke[] sl, Vielflach[] kl) {
 	this.punktliste = pl;
	this.streckeliste = sl;
	this.vielflachliste = kl;
    }

    // public Dreipunkt[] nehmePunkten() {
	
    // }

    // public Zweistrecke[] nehmekanten() {
	
    // }
}
