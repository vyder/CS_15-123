#!/bin/bash

cd submissions/		# Stepping down into submissions/
FILES="`echo *`"	# FILES now has a string of filenames
wget "http://www.cs.cmu.edu/~thoffman/M09-15123/getline/getline.h"	# Downloading getline stuff into submissions/
wget "http://www.cs.cmu.edu/~thoffman/M09-15123/getline/getline.c"

for FILE in $FILES	# Looping through all the files
do
	str_length=${#FILE}		# Getting length of the file name
	andrewID=${FILE:0:str_length-2} # Parsing andrewID from filename using substring (That's why I calculated length)
	mkdir $andrewID			# Creating directory andrewID/
	cp $FILE $andrewID		# Copying the C file into andrewID/
	cp getline.h $andrewID		# Copying the getline stuff into andrewID/
	cp getline.c $andrewID
	cd $andrewID			# Stepping down into andrewID/
	gcc -ansi -pedantic -W -Wall -O2 $FILE 2>> ../compilationLog.txt # Compiling code, redirecting output to a common txt file
	cd ..				# Stepping up into submissions/
done			# End of Loop
