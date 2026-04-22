package vieleck;

import vektor.Zweivektor;
import strecke.Zweistrecke;

// Ein Vieleck ist eine Art Figur, die aus mindestens drei durch
// Linien verbundenen, voneinander verschiedenen Zweivektoren gebaut
// ist.
//
// Ein Vieleck ist eine Liste von zweidimensionalen Vektoren. Das
// Vieleck kann eine Fläche eines dreidimensionalen Körpers zeigen.
//
// Ein Vieleck kennt seinen Ort in einer Welt nicht.
//
// Ein Vieleck ist ein zweidimensionaler Ding.
//
// Ein Vieleck besitzt immer wie der Körper einen Inhalt.
//
// Eine Strecke, ein Weg oder ein Vektor sind kein Vieleck noch
// kein Körper.
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

    // aus: Liste von Zweivektoren
    //
    // Nehme alle die Ecken dieses Vielecks.
    public abstract Zweivektor[] nehmeecken();
}
