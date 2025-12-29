package punktkoerper;

import koerper.Koerper;
import kante.Dreikante;
import punkt.Dreipunkt;

// Ein verorteter Körper. Nach einer Entstehung eines
// Punktkörpers, können wir im Prinzip genau die Stellen jeder
// Dreikante und Ecke dessen. Ein Punktkörper ist ein verorteter
// Körper.
//
// Ein Punktkörper ist ein Paar von
// - Dreipunkt
// - Körper
//
// Ein Punktkörper kennt seinen eigenen Ort innerhalb der Welt.  Wir
// müssen eine Verbindung zwischen Ecken und Stellen bestimmen. Die
// bestimmte Beschaffung dieses Körpers wird kennen, wie viele Ecke
// und Dreikanten dieses Körpers es gibt.
public abstract class Punktkoerper {

    // Der Ort dieses Körpers
    public Dreipunkt punkt;
    
    // ein:
    // aus: Liste von Dreikanten
    // Nehme alle die Dreikanten dieses Körpers. Daher müssen wir über den
    // Ort des Körpers beachten.
    public abstract Dreikante[] nehmeKanten();
}
