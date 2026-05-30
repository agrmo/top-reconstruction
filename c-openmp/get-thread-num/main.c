#include <omp.h>
#include <stdio.h>

// gcc -fopenmp get-thread-num/main.c -o main
// clang -fopenmp main.c
// ldd a.out

void beispieleins() {
#pragma omp parallel
  {
    printf("Thread id is %d\n", omp_get_thread_num());
  }
}

void beispielzwei() {
  int id;
  
#pragma omp parallel
  {
    id = omp_get_thread_num();
    printf("Hello World from thread %d\n", id);
  }

  // Manchmal beantwortet der Thread 1 erst, manchmal der Thread 2.
}

int main(void) {
  beispielzwei();
  return 0;
} 
