#include <iostream>

int recursive(int sum, int i) {
  //printf("%i ",i);
  if (i == 1)
    return 1;
  sum *= i;
  return recursive(sum,i-1);
}

int main(int argn, char** argv) {
  int f = recursive(1, atoi(argv[1]));
  std::cout << f << std::endl;
}
