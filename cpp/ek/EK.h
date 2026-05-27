#ifndef EK_H
#define EK_H

class Knoten {
public:
  int wert;
  Knoten* naechste;
  Knoten(int w);
};

void druck(Knoten* knoten);

#endif
