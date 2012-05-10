# Make file that builds executable file main.exe

CC= gcc 
FLAGS=  -pedantic  -ansi -W -Wall

a.out : Lab2main.o Lab2lib.o 
	$(CC)$(FLAGS) -o a.out Lab2main.o Lab2lib.o
	

Lab2main.o : Lab2main.c Lab2lib.h 
	$(CC)$(FLAGS) -c Lab2main.c 

Lab2lib.o : Lab2lib.c Lab2lib.h 
	$(CC)$(FLAGS) -c Lab2lib.c 
