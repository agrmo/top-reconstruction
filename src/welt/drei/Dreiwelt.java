package welt.drei;
    
import vektor.Dreivektor;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vieleck.Vieleck;
import vielflach.Vielflach;
import welt.punkt.Punktwelt;
import welt.vielflach.Vielflachwelt;

// Eine Dreiwelt enthält ein-, zwei- und dreidimensionale
// Dingen. D.h. Vektoren, Vielecken und Körper. Sie ist ein
// allgemeiner Aufbau.
public class Dreiwelt {

    Punktwelt pw;
    Vielflachwelt vw;

    public Dreiwelt(Punktwelt pw, Vielflachwelt vw) {
	this.pw = pw;
	this.vw = vw;
    }

    public Dreivektor[] nehmepunkte() {
	return this.pw.orte;
    }

    public Dreistrecke[] nehmekanten() {
	return this.vw.nehmekanten();
    }
}
