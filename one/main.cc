#include <iostream>
#include <vector>

#include "util.h"

#define SIZE 9

bool backTrack(std::vector<std::vector<int>>&);

int main(int argn, char** argv) {
  if (argn < 2) {
    std::cout << "Wrong number of arguments\n";
    return 1;
  }
  std::vector<std::vector<int>> sudoku = readFile(argv[1]);
  printSudoku(sudoku);
  std::cout << "--------------------------\n";
  backTrack(sudoku);
  printSudoku(sudoku);
  return 0;
}

bool backTrack(std::vector<std::vector<int>>& sudoku) {

  for(int j = 0; j < SIZE; ++j) {
    for(int i = 0; i < SIZE; ++i) {
      if (sudoku[j][i] == 0) {
	for (int n = 1; n <= 9; ++n) {
	  if (canPlace(sudoku, n, i, j)) {
	    sudoku[j][i] = n;
	    if (!backTrack(sudoku))
	      continue;
	    else
	      return true;
	  }
	}
	sudoku[j][i] = 0;
	return false;
      }
    }
  }
  return true;
}
