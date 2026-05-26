#include <iostream>
#include "EK.h"
using namespace std;

// g++ zeiger/Main.cpp -o main 

int main() {
  int zahl = 10;
  int& zeiger = zahl;

  cout << zeiger << endl;

  zeiger = 22;

  cout << zeiger << endl;

  return 0;
}
