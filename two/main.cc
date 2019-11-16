#include <iostream>
#include <vector>
#include <stdlib.h>

#include "util.h"

int main(int n, char** arg) {
  std::cout << sizeof(int) << std::endl;
  std::vector<std::vector<int>> field = readField(arg[1]);
  std::vector<std::pair<int,int>> coord_list;
  //printField(field);
  //std::cout << "size of Y: " << field.size() << " and size of X: " << field[0].size() << std::endl;
  int size_x = field[0].size() * sizeof(int);
  int size_total = field.capacity() * sizeof(field) + size_x * field.size();
  //std::cout << "total size of field: " << size_total << " and size of field " << sizeof(field) << std::endl;

  //std::cout << "field 0 size:" << field[0].size() << " field 0 capacity " << field[0].capacity() << std::endl;
  //std::cout << "field size:" << field.size() << " field capacity " << field.capacity() << std::endl;
  setY(field.size());
  setX(field[0].size());
  int number_of_groups = 0;
  for(int y = 0; y < field.size(); ++y)
    for(int x = 0; x < field[y].size(); ++x) {
      if (field[y][x] == 1) {
	std::cout << "Zombie found on place>> x: " << x << " y: " << y << std::endl;
	number_of_groups++;
	coord_list.emplace_back(x,y);
	while(coord_list.size() > 0) {
	  std::pair<int, int> coord_pair = coord_list.back();
	  coord_list.pop_back();
	  group(field, coord_pair.first, coord_pair.second, coord_list);
	}
      }
    }
  std::cout << "Number of zombie groups are: " << number_of_groups << std::endl;
}
