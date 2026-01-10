package vielflach;

import strecke.Dreistrecke;
import punkt.Dreipunkt;

// Ein Vielflach ist eine dreidimensionale Körper, die durch eine
// Reihe von Punkten bestimmt ist.
public abstract class Vielflach {

    // aus: ganze Zahl
    //
    // Nehme die Anzahl der Strecken dieses Körpers.
    public abstract int nehmeeckenanzahl();

    // aus: ganze Zahl
    //
    // Nehme die Anzahl der Strecken dieses Körpers.
    public abstract int nehmekantenanzahl();

    // aus: Liste von Punkten
    //
    // Nehme alle Strecken dieses Körpers.
    public abstract Dreipunkt[] nehmeecken();
    
    // aus: Liste von Strecken
    //
    // Nehme alle Strecken dieses Körpers.
    public abstract Dreistrecke[] nehmekanten();
}
