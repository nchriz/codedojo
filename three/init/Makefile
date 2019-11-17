CC = g++ --std=c++14

DIR = src

OBJ_ = main.o
OBJ = $(patsubst %,$(DIR)/%,$(OBJ_))

run: $(OBJ)
	$(CC) -o $@ $^

$(DIR)/%.o: %.cc $(OBJ)
	$(CC) -c -o $@ $<

clean:
	rm $(OBJ) $(DIR)/*~ run range.csv *~
