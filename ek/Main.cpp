#include <iostream>
#include "EK.h"
using namespace std;

// g++ ek/EK.cpp ek/Main.cpp -o main

int main() {
  Knoten* kopf = new Knoten(2);
  kopf->naechste = new Knoten(4);

  druck(kopf);
}
