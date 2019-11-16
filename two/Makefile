CC = g++ --std=c++14

run: main.o util.o
	$(CC) -o run main.o util.o

main.o: main.cc util.h
	$(CC) -c -o main.o main.cc

util.o: util.cc util.h
	$(CC) -c -o util.o util.cc

clean:
	rm *~ *.o
