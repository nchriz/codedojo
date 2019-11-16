#include "util.h"

using namespace std;

int size_x = 0, size_y = 0;

vector<vector<int>> readField(string name) {
  ifstream is(name);
  char c;
  vector<vector<int>> field;
  vector<int> row;
  int i;
  
  while(is.get(c)) {
    i = (int) c - '0';
    if (i == 0 || i == 1)
      row.push_back(i);
    if (c == '\n') {
      field.push_back(row);
      row.clear();
    }
  }
  is.close();
  return field;
}

void printField(const vector<vector<int>>& field) {
  for(int i = 0; i < field.size(); ++i) {
    for(int j = 0; j < field[i].size(); ++j)
      cout << field[i][j];
    cout << endl;
  }
}

void setX(int x) {
  size_x = x;
}

void setY(int y) {
  size_y = y;
}

void group(vector<vector<int>>& field, int x, int y, vector<pair<int,int>>& coord_list) {
  if (x < 0 || x > field[y].size() - 1)
    return;
  if (y < 0 || y > field.size() - 1)
    return;
  if (field[y][x] == 0)
    return;

  field[y][x] = 0;

  coord_list.emplace_back(x, y - 1);
  coord_list.emplace_back(x, y + 1);
  coord_list.emplace_back(x - 1, y);
  coord_list.emplace_back(x + 1, y);
}
