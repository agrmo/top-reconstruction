#include <iostream>
#include "EK.h"
using namespace std;

// Eine einseitige Kette.
// engl. Linked List;
// Auch eine Art Graphen.
// Jeder Knoten besitzt einen Zeiger zum nächsten Knoten.

Knoten::Knoten(int w) {
  wert = w;
  naechste = nullptr;
}

void druck(Knoten* knoten) {
  Knoten* k = knoten;

  while (k != nullptr) {
    cout << k->wert;
    
    if (k->naechste != nullptr) {
      cout << " -> ";
    }

    k = k->naechste;
  }
}
