package koerper;

import strecke.Dreistrecke;

// Ein Körper ist ein dreidimensionaler Ding. Er besitzt immer einen
// Rauminhalt. Wir können einen Körper mit Hilfe der Sicht betrachten.
// Er besitzt verschiedene Eigenschaften, die für ihn wichtig ist,
// seine Ausdehnung zu zeigen. Die Welt enthält verschiedene Körper.
// In verschiedenen Metriken kann der gleiche Körper anders
// aussehen. Also wir können nicht seine Stelle, seinen Platz oder
// seinen Ort wie seine Eigenschaften bestimmen. Die Welt wird uns
// zeigen, wo ein Körper steht. Trotzdem müssen wir manchmal eine
// Eigenschaft annehmen, die nur in Euklidraum in eins, zwei oder drei
// Dimensionen gilt. Zum Beispiel, ein Kubus besitzt eine Länge in
// euklidischem Raum, aber diese Länge können nach
// Lorentz-Beschleunigung anders aussehen. Die Welt wird uns den
// Unterschied erklären.
//
public abstract class Koerper {

    // aus: Liste von Strecken
    //
    // Nehme alle Strecken dieses Körpers. Daher müssen wir über den Ort
    // des Körpers beachten.
    public abstract Dreistrecke[] nehmeStrecken();

    // aus: ganze Zahl
    //
    // Nehme den Betrag der Strecken dieses Körpers. Genau wie viele
    // Dreistrecke es gibt in nehmeStrecken().
    public abstract int nehmestreckenanzahl();
}
