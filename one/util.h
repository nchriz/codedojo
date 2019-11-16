#ifndef UTIL_H
#define UTIL_H

#include <fstream>
#include <iostream>
#include <string>
#include <vector>

std::vector<std::vector<int>> readFile(const std::string);
void printSudoku(const std::vector<std::vector<int>>&);
bool canPlace(const std::vector<std::vector<int>>&,int,int,int);
#endif
