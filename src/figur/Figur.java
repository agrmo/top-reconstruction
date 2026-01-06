package figur;

import kante.Zweikante;
import punkt.Zweipunkt;

// Eine Figur ist ein zweidimensionaler Ding.
//
// Eine Figur besitzt immer wie der Körper einen Inhalt.
//
// Eine Strecke, ein Weg und ein Punkt sind nicht Figuren oder
// Körpern.
public abstract class Figur {

    // aus: Liste von Zweikanten
    //
    // Nehme alle die Zweikanten dieser Digur. Daher müssen wir über
    // den Ort der Figur beachten.
    public abstract Zweikante[] nehmeKanten();

    // aus: Liste von Zweipunkten
    //
    // Nehme alle Ecken dieser Figur.
    public abstract Zweipunkt[] nehmeEcken();
}
