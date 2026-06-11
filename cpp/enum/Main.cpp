#include "Enum.h"
#include <iostream>
using namespace std;

// g++ enum/Enum.h enum/Main.cpp -o main

int main() {
  enum Farbe meinefarbe = ROT;

  cout << meinefarbe << endl;

  return 0;
}
