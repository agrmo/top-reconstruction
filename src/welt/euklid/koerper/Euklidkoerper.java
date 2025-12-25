package welt.euklid.koerper;

import vektor.Vektor;
import koerper.Koerper;

// Ein Körper, gebildet von Vektoren im Euklidraum. Nach einer
// Entstehung eines Vektorkoerpers, können wir im Prinzip genau die
// Stellen jeder Kante und Ecke dessen. Ein Euklidkörper ist ein
// verorteter Körper. 
//
// Ein Euklidkörper ist ein Paar von
// - Vektor
// - Koerper
public abstract class Euklidkoerper {

    // Dieser Körper.
    Koerper koerper;

    // Der Ort dieses Körpers
    Vektor ort;

    // Also ein Euklidkörper kennt den Ort des Körpers.

    // Wir müssen eine Verbindung zwischen Ecken und Stellen
    // bestimmen. Die bestimmte Beschaffung dieses Körpers wird
    // kennen, wie viele Ecke und Kanten dieses Körpers es gibt.
}
