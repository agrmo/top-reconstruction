package vieleck;

import punkt.Zweipunkt;
import strecke.Zweistrecke;

// Ein Vieleck ist eine Vieleck, die aus mindestens drei durch Linien
// verbundenen, voneinander verschiedenen Zweipunkten besteht.
//
// Ein Vieleck ist eine Liste von zweidimensionalen Punkten. Das
// Vieleck kann eine Fläche eines dreidimensionalen Körpers zeigen.
//
// Ein Vieleck kennt seinen Ort in einer Welt nicht.
//
// Eine Vieleck ist ein zweidimensionaler Ding.
//
// Eine Vieleck besitzt immer wie der Körper einen Inhalt.
//
// Eine Strecke, ein Weg und ein Punkt sind nicht Vielecken oder
// Körpern.
public abstract class Vieleck {
    
    // aus: ganze Zahl
    //
    // Nehme den Betrag der Strecken dieses Vielecks.
    public abstract int nehmekantenanzahl();

    // aus: ganze Zahl
    //
    // Nehme die Anzahl der Strecken dieses Vielecks.
    public abstract int nehmeeckenanzahl();
    
    // aus: Liste von Zweistrecken
    //
    // Nehme alle die Kanten dieses Vielecks.
    public abstract Zweistrecke[] nehmekanten();

    // aus: Liste von Zweipunkten
    //
    // Nehme alle die Ecken dieses Vielecks.
    public abstract Zweipunkt[] nehmeecken();
}
