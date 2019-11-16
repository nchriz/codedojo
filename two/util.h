#ifndef UTIL_H
#define UTIL_H

#include <vector>
#include <string>
#include <fstream>
#include <iostream>

std::vector<std::vector<int>> readField(std::string);
void printField(const std::vector<std::vector<int>>&);

void setX(int);
void setY(int);

void group(std::vector<std::vector<int>>&, int, int, std::vector<std::pair<int,int>>&);

#endif
