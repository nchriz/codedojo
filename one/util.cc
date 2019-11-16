#include "util.h"

using namespace std;

#define SIZE  9

vector<vector<int>> readFile(const string name) {
  ifstream in(name);
  char c;
  
  vector<vector<int>> file(SIZE, vector<int>(SIZE,1));
  int x = 0, y = 0;
  while(in.get(c)) {
    if (c == '\n') {
      file[++y];
      x = 0;
      continue;
    } 
    file[y][x++] = (int) c - '0';
  }
  return file;
}

void printSudoku(const vector<vector<int>>& sudoku) {
  for (int i = 0; i < SIZE; ++i) {
    if (i % 3 == 0 && i > 0)
      cout << endl;
    for (int j = 0; j < SIZE; ++j) {
      if (j % 3 == 0 && j > 0)
	cout << " ";
      cout << sudoku[i][j];
    }
    cout << endl;
  }
}

bool placeLine(const vector<vector<int>>& sudoku, int n, int x, int y) {
  for (int i = 0; i < SIZE; ++i) {
    if (i == x)
      continue;
    if (sudoku[y][i] == n)
      return false;
  }
  for (int i = 0; i < SIZE; ++i) {
    if (i == y)
      continue;
    if (sudoku[i][x] == n)
      return false;
  }
  return true;
}

bool placeBox(const vector<vector<int>>& sudoku, int n, int x, int y) {
  int lowX = x - x%3;
  int lowY = y - y%3;

  for (int i = lowY; i < lowY + 3; ++i)
    for (int j = lowX; j < lowX + 3; ++j)
      if (sudoku[i][j] == n)
	return false;
  return true;
}

bool canPlace(const vector<vector<int>>& sudoku, int n, int x, int y) {
  return placeBox(sudoku, n, x, y) && placeLine(sudoku, n, x, y);
}
