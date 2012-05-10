# Make file that builds executable file a.out

CC= gcc 
FLAGS=  -pedantic  -ansi -W -Wall

a.out : lab3main.o lib3.o getline.o
	$(CC)$(FLAGS) -o a.out lab3main.o lib3.o getline.o

lab3main.o : lab3main.c lib3.h
	$(CC)$(FLAGS) -c lab3main.c

lib3.o : lib3.c lib3.h
	$(CC)$(FLAGS) -c lib3.c

getline.o : getline.c getline.h
	$(CC)$(FLAGS) -c getline.c 