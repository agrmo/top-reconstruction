package figur;

import strecke.Zweistrecke;
import punkt.Zweipunkt;

// Eine Figur ist ein zweidimensionaler Ding.
//
// Eine Figur besitzt immer wie der Körper einen Inhalt.
//
// Eine Strecke, ein Weg und ein Punkt sind nicht Figuren oder
// Körpern.
public abstract class Figur {

    // aus: Liste von Zweistrecken
    //
    // Nehme alle die Kanten dieser Digur. Daher müssen wir über
    // den Ort der Figur beachten.
    public abstract Zweistrecke[] nehmeStrecken();

    // aus: ganze Zahl
    //
    // Nehme den Betrag der Strecken dieses Körpers. Genau wie viele
    // Dreistrecke es gibt in nehmeStrecken().
    public abstract int nehmestreckenanzahl();

    // aus: Liste von Zweipunkten
    //
    // Nehme alle Ecken dieser Figur.
    public abstract Zweipunkt[] nehmeEcken();
}
