package vielflach;

import strecke.Dreistrecke;
import vektor.Dreivektor;

// Ein Vielflach ist eine dreidimensionale Körper, die durch eine
// Reihe von Vektoren bestimmt ist.
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
    // Nehme alle Strecken dieses Körpers.
    public abstract Dreivektor[] nehmeecken();
    
    // aus: Liste von Strecken
    //
    // Nehme alle Strecken dieses Körpers.
    public abstract Dreistrecke[] nehmekanten();
}
