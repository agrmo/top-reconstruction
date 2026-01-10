package figur.vieleck;

import java.util.ArrayList;
import punkt.Zweipunkt;

// Ein Vieleck ist eine Figur, die aus mindestens drei durch Linien
// verbundenen, voneinander verschiedenen Zweipunkten besteht.
//
// Ein Vieleck ist eine Liste von Zweipunkten. Die Vieleck kann eine
// Fläche eines dreidimensionalen Körpers zeigen.
//
// Ein Vieleck ist in zwei Dimensionen bestimmt, während eine Fläche
// ist in drei Dimensionen bestimmt.
public class Vieleck {

    // Eine geordnete Reihe von Zweipunkten, die eine Fläche bildet.
    // Die Ordung der Zweipunkten ist hier sehr wichtig, sodaß wir die
    // Zweipunkten entweder gegen oder in den Uhrzeigersinn
    // durchlaufen können, um das Vieleck aufzubauen.
    public ArrayList<Zweipunkt> ecken;

    // ein: Liste von Zweipunkten
    public Vieleck(ArrayList<Zweipunkt> pl) {
	this.ecken = pl;
    }
}
