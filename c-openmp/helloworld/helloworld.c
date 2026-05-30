#include <stdio.h>
#include <omp.h>

// gcc -fopenmp helloworld/helloworld.c -o main
// clang -fopenmp helloworld/helloworld.c -o main
// ldd main

// With two cores and a thread-safe implementation of printf will the
// output be,
//
// "Hello, World."
// "Hello, World."
//
// But if the printf implementation is not thread-safe, then the
// output will be garbled.
//
// "HelHell low
// orld world."
int main(void) {
    #pragma omp parallel
    printf("Hello, world.\n");
    return 0;
}
