package vielflach;

import strecke.Dreistrecke;
import vektor.Dreivektor;

// Ein Vielflach ist ein dreidimensionaler Körper, der von Ecken
// bestimmt ist.
public abstract class Vielflach {

    // aus: ganze Zahl
    //
    // Nehme die Anzahl der Strecken dieses Körpers.
    public abstract int nehmeeckenanzahl();

    // aus: ganze Zahl
    //
    // Nehme die Anzahl der Strecken dieses Körpers.
    public abstract int nehmekantenanzahl();

    // aus: Liste von Vektoren
    //
    // Nehme die Orte aller Ecken dieses Körpers.
    public abstract Dreivektor[] nehmeecken();
    
    // aus: Liste von Strecken
    //
    // Nehme alle Strecken dieses Körpers.
    public abstract Dreistrecke[] nehmekanten();
}
