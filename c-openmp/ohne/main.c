#include <omp.h>
#include <stdio.h>

// Problem: Wir wollen ein Programm benutzen, aber manchmal haben wir
// OpenMP zur Verfügung gestellt, und manchbal nicht. Können wir ein
// Programm schreiben mit der Fähigkeit, mit und auch ohne OpenMP zu
// rechnen?

// gcc -fopenmp ohne/main.c -o main
// gcc ohne/main.c -o main

void beispieleins() {
  int id = 0;
   #pragma omp parallel
   {
#ifdef _OPENMP
   id = omp_get_thread_num();
#else
   id = 0;
#endif
   printf("Hello World from thread %d\n", id);
   }
}

int main(void) {
  beispieleins();
  return 0;
}
