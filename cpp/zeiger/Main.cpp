#include <iostream>
using namespace std;

// g++ zeiger/Main.cpp -o main && ./main

void beispieleins() {
  string essen = "Brot";
  cout << essen << endl; // "Brot"
  cout << &essen << endl; // 0x
}

void beispielzwei() {
  string essen = "Brot";
  string* zeiger = &essen;
  cout << zeiger << endl; // 0x  
}

int main() {
  beispieleins();

  return 0;
}
