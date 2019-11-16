CC = g++ -std=c++14

run: main.o util.o
	$(CC) -O3 -o run main.o util.o

main.o: main.cc util.h
	$(CC) -c -O3 -o main.o main.cc

util.o: util.cc util.h
	$(CC) -c -O3 -o util.o util.cc

clean:
	rm *~ *.o
