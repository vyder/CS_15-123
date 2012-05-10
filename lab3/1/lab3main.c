#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "lab-03-lib.h"
#include "getline.h"

int main( int argc, char **argv )
{
	int cap = 1;
	int count =0;
	char ** dictionary = malloc( cap * sizeof(char *) );

	if (argc < 2) exit(0);

	load( argv[1], &dictionary, &count, &cap );

	menu(dictionary, &count, argv[2],&cap);

	return 0;
	
}
