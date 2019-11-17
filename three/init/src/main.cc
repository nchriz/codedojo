#include <algorithm>
#include <fstream>
#include <iostream>
#include <random>
#include <vector>

struct binRange {
  long low;
  long high;
  binRange(long low, long high) : low(low), high(high) {
  }
};

int myRandom(int i) {
  return std::rand()%i;
}

void printVector(std::vector<binRange>& v) {
  for (binRange& range : v)
    std::cout << "lower " << range.low << " higher " << range.high << "\n";
}

void writeToFile(std::vector<binRange>& v) {
  std::ofstream out("range.csv");
  out << "low,high\n";
  for (binRange& range : v)
    out << range.low << "," << range.high << "\n";
}

int main(int argn, char** argv) {
  std::srand(std::time(NULL));
  if (argn < 2) {
    std::cerr << "Specify range of values\n";
    return 1;
  }
  std::vector<binRange> v;
  int max = atoi(argv[1]), jump = 1000;;
  for (int i = 0; i < max; ++i) {
    v.push_back(binRange(i*jump, (i+1)*jump));
  }
  //printVector(v);
  std::random_shuffle(v.begin(), v.end(), myRandom);
  //printVector(v);
  writeToFile(v);
  return 0;
}
