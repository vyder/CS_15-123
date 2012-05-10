#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#DEFINE MAX_WORDS 50000 /* Rows */
#DEFINE MAX_WORDLEN 50  /* Columns */

void loadDictionary( char *infilename, char dictionary[][MAX_WORDLEN], int *count )
{
	FILE *infile;
	char wordBuffer[MAX_WORDLEN];
	infile = fopen( *infilename, "rt" );
	
	while( fgets(wordBuffer, MAX_WORDLEN, infile) )
	{
		removeNewln( wordBuffer );
		
		insert( dictionary, wordBuffer, count );
	}
	
	fclose( infile );
}

int main( int argc, char *argv[] )
{
	char dictionary[MAX_WORDS][MAX_WORDLEN];
	int count=0;
	
	loadDictionary( argv[1], dictionary, &count);
	
	menu( dictionary, &count, argv[2] );
	
	return EXIT_SUCCESS;
}
