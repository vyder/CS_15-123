#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "Lab2lib.h"

int main( int argc, char *argv[] )
{
	char dictionary[MAX_WORDS][MAX_WORDLEN];
	int count=0;
	
	if(argc < 3)
	{
		printf("You need to enter two args: input filename, and output filename\n");
		exit(EXIT_FAILURE);
	}
	
	loadDictionary( argv[1], dictionary, &count ); 

	menu( dictionary, &count, argv[2] );
		
	return EXIT_SUCCESS;
}
