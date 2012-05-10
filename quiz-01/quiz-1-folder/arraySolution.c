/*
	solution.c  for practice Exam#1  the Array version of the problem.
	An input filename must be passed on the command line.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "getline.h"

#define INITIAL_CAPACITY 5

typedef struct
{
	char *word;
	int   freq;
} Elem;

void buildArray(char *fileName, Elem ** array, int * cnt, int *cap );
void printArrayOgram(Elem *array, int cnt);
void freeArray(Elem **array, int *can, int * cap);
int search( Elem *list, int cnt, char *word );
void insertAtFront( Elem **list, int *cnt, int *cap, char *word );
void fatal( char * msg );

int main(int argc, char *argv[] )
{
	Elem *array =  malloc( INITIAL_CAPACITY * sizeof(Elem) );
	int cap = INITIAL_CAPACITY;
	int cnt = 0;

	if (argc<2 ) fatal("Must enter input file name in cmd line\n");
	if (!array) fatal("Initial malloc in main failed\n");

	buildArray(  argv[1], &array, &cnt, &cap );
	printArrayOgram( array, cnt );
	freeArray(&array, &cnt, &cap);
	printArrayOgram( array, cnt ); /* just to prove you got em all and got em right :=) */
	return 0;
}

/* --------------------------------------------------------------------------------------------------*/

void buildArray(char *fileName, Elem ** array, int * cnt, int *cap )
{
	char *word;
	FILE *inFile = fopen(fileName, "r");

	if (!inFile) fatal("Can't open infile\n");

	while ( fgetline_123( &word, inFile ) )
	{
		int index = search( *array, *cnt, word );
		if (index == -1)
			insertAtFront( array,  cnt, cap,  word );
		else
		{
			free( word );
			 ++(*array)[index].freq;
		}
  	} /* DONE READING FROM FILE */

  	free(word);
	fclose( inFile );

} /* END buildArray */

void printArrayOgram(Elem *array, int cnt)
{
	int i;
	printf("\nArrayOGram: ");
	if (!cnt)
	{
		printf("<EMPTY> \n");
		return;
	}
	printf("\n");
	for (i=0 ; i<cnt;++i )
	{
		int star;
		printf("%s: ", array[i].word );
		for (star=0 ; star < array[i].freq ; ++star)
			printf("*");
		printf("\n");
	}
}

void freeArray(Elem **array, int *cnt, int * cap)
{
	int i;
	for(i=0 ; i<*cnt ; ++i)
		free( (*array)[i].word );
	free(*array);
	*cnt=*cap=0;
}

void insertAtFront( Elem **array, int * cnt, int *cap, char * word )
{
	int i=0;
	if (*cnt==*cap)
	{
		*array = realloc( *array, *cap * 2 * sizeof(Elem) );
		*cap *= 2;
		printf("Just resized array to %d elements\n", *cap  );
	}
	for(i=*cnt-1 ; i>=0 ; --i)
		(*array)[i+1] = (*array)[i];  /* shift ALL elem up one */
	(*array)[0].freq = 1;
	(*array)[0].word = word;
	++(*cnt);
}

int search( Elem *array, int cnt, char *word )
{
	int i;
	for (i=0 ; i<cnt ; ++i )
		if ( strcmp(array[i].word, word)==0 )
			return i;

	return -1; /* NOT FOUND */
}

void fatal( char * msg )
{
	printf("\nFatal Error: %s\n\n", msg );
	exit(0);
}
