# codedojo
I'm holding a series of monthly Code Dojos. Below will be a small introduction to each Code Dojo and I will publish the solution in this repository. When specify, the challenge files will be in respective folder. The solutions will be in basic C++ 14 if not specified.

I publish articles where I go through the code at https://dev.to/nchrisz

## First

A town have been infested by zombies. To best combat them you need to find out how many groups there are active in the town. A grid will represent a town where a 0 is a human and a 1 is a zombie. Adjacent number, horizontal or vertical, mean they are part of the same group.

Example

10
01

is a town with 4 creatures, 2 humans and 2 zombies. As the 1 are not adjacent we have 2 zombie groups here.

Write a program that will take a grid and calculate how many groups of zombies there are. Solve the gird in folder one

## Second

Write a sudoku solver that can solve following sudokus:
```
easy:
070630094
104000200
083420700
002040030
090080040
050060900
009054310
007000509
530092080

medium:
000007590
409008000
050010000
100200900
300070005
006003004
000080060
000500302
083700000

challenge:
000000000
000003085
001020000
000507000
004000100
090000000
500000073
002010000
000040009
```

## Third

Having a large set of data, represented in range.csv, find a solution to retrieve a specific row.
To get a row, give it a integer and the server will find the range that hold the integer and response with that row.

Example
```
DATASET:
570000000,570000999
946570000,946570999
766899000,766899999
347957000,347957999
59958000,59958999

REQUEST 347957123
RESPONSE 347957000,347957999
```

## Fourth

Christmas Special: Reindeer race. Client register reindeers with the Server which control the race.

Endpoints of the Server
```
@RequestMapping(method = RequestMethod.POST, value = "/{id}/drawMap/{map}")
public ResponseEntity drawMap(@PathVariable(value = "id") UUID id, @PathVariable(value = "map") String map);

@RequestMapping(method = RequestMethod.POST, value = "/{id}/clear")
public ResponseEntity clearMap(@PathVariable(value = "id") UUID id);

@RequestMapping(method = RequestMethod.POST, value = "/{id}/startRace")
public ResponseEntity startRace(@PathVariable(value = "id") UUID id);

@RequestMapping(method = RequestMethod.POST, value = "/createBlindeer/{color}")
public ResponseEntity<CreateDeerDto> createBlindeer(@PathVariable(value = "color") String color);

@RequestMapping(method = RequestMethod.POST, value = "/{id}/move/{move}")
public ResponseEntity<MovedDeerDto> moveRaindeer(@PathVariable(value = "id") UUID id, @PathVariable(value = "move") Move move);

```
id for the server is: 0ef506e8-5f6b-45ed-a81a-53eab6d7eb6b

Flow:
1. Start the Server - Server side
2. Draw Map [1,3] - Server side
3. Register Reindeer - Client side
4. Start Race - Server side
5. Move Reindeer - Client side

The response from 3 will be the UUID that identify the reindeer.
Response from 5 will be 200 with either Success or Fail (if movement worked) and new coordinates.