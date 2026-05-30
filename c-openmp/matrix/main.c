#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>

// gcc -fopenmp matrix/main.c -o main

int main(int argc, char **argv) {
  
  struct timespec ts_start, ts_end;
  int size = 1000;
  int a[size][size];
  int i, j;

  // Am Anfang hat alle Zahlen den Wert 1
  for (i = 0; i < size; i++) {
    for (j=0; j < size; j++) {
      a[i][j] = 1;
    }
  }
  
  // Mache eine Summe jedes Teiles der Matrix.
  // Aber die Summe wird in size-mal Schlaufen verteilt.
  int total = 0;
  int c[size];

  // Zero the accumulator 
  for (i = 0; i < size; i++) {
    c[i] = 0;
  }
  float time_total;
  
  clock_gettime(CLOCK_MONOTONIC, &ts_start);
  
  
#pragma omp parallel for
  for (i = 0; i < size; i++) {
    for (j = 0; j < size; j++) {
      c[i] = c[i] + a[i][j];
    }
  }
  
  for (i = 0; i < size; i++) {
    total = total + c[i];
  }
  
  clock_gettime(CLOCK_MONOTONIC, &ts_end);
  
  time_total = (ts_end.tv_sec - ts_start.tv_sec) * 1000000000
    + (ts_end.tv_nsec - ts_start.tv_nsec);
  
  printf("Total is %d, time is %f ms\n", total, time_total/1000000);
}
