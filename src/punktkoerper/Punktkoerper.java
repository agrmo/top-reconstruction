package punktkoerper;

import punkt.Punkt;
import koerper.Koerper;
import kante.Kante;

// Ein Körper, der seinen Ort kennt. Nach einer
// Entstehung eines Punktkörpers, können wir im Prinzip genau die
// Stellen jeder Kante und Ecke dessen. Ein Punktkörper ist ein
// verorteter Körper. 
//
// Ein Punktkörper ist ein Paar von
// - Punkt
// - Körper
public abstract class Punktkoerper {
    
    // Ein Punktkörper kennt seinen eigenen Ort innerhalb der Welt.  Wir
    // müssen eine Verbindung zwischen Ecken und Stellen
    // bestimmen. Die bestimmte Beschaffung dieses Körpers wird
    // kennen, wie viele Ecke und Kanten dieses Körpers es gibt.

    // ein:
    // aus: Liste von Kanten
    // Nehme alle die Kanten dieses Körpers. Daher müssen wir über den
    // Ort des Körpers beachten.
    public abstract Kante[] nehmeKanten();
}
