package punktkoerper;

import koerper.Koerper;
import kante.Dreikante;

// Ein verorteter Körper. Nach einer Entstehung eines
// Punktkörpers, können wir im Prinzip genau die Stellen jeder
// Dreikante und Ecke dessen. Ein Punktkörper ist ein verorteter
// Körper.
//
// Ein Punktkörper ist ein Paar von
// - Dreipunkt
// - Körper
public abstract class Punktkoerper {
    
    // Ein Punktkörper kennt seinen eigenen Ort innerhalb der Welt.  Wir
    // müssen eine Verbindung zwischen Ecken und Stellen
    // bestimmen. Die bestimmte Beschaffung dieses Körpers wird
    // kennen, wie viele Ecke und Dreikanten dieses Körpers es gibt.

    // ein:
    // aus: Liste von Dreikanten
    // Nehme alle die Dreikanten dieses Körpers. Daher müssen wir über den
    // Ort des Körpers beachten.
    public abstract Dreikante[] nehmeKanten();
}
