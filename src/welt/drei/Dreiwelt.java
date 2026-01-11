package welt.drei;
    
import vektor.Dreivektor;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vieleck.Vieleck;
import vielflach.Vielflach;

// Eine Dreiwelt enthält ein-, zwei- und dreidimensionale
// Dingen. D.h. Vektoren, Vielecken und Körper.  Sie enthält keine Farbe.
// Die Vektoren, Vielecken und Körper stehen in ihre eigene Listen. 
public class Dreiwelt {

    // Diese Welt enthält Vektoren, Strecken, Vielecken und Körpern.
    public Dreivektor[] vektorliste;
    public Dreistrecke[] streckeliste;
    public Vieleck[] vieleckliste;
    public Vielflach[] vielflachliste;

    // Die Vielecken und Körper müssen einen Ort besitzen.
    public Dreivektor[] vieleckorten;
    public Dreivektor[] vielflachorten;

    // Die Vielecken und Körper müssen eine Ausrichtung besitzen.
    public Dreivektor[] vieleckausrichtungen;
    public Dreivektor[] vielflachausrichtungen;

    public Dreiwelt(Dreivektor[] pl, Dreistrecke[] sl, Vielflach[] kl) {
 	this.vektorliste = pl;
	this.streckeliste = sl;
	this.vielflachliste = kl;
    }

    // public Dreivektor[] nehmeVektoren() {
	
    // }

    // public Zweistrecke[] nehmekanten() {
	
    // }
}
