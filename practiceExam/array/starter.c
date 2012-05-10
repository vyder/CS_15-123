/*
	starter.c for Array version of the REVERSAL  problem
	1 input file required to be passed on cmd line
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "getline.h"

#define INITIAL_CAPACITY 2

typedef struct Elem
{
	char *  word;
} Elem;


void insertInOrder( Elem **array, char * word, int * cnt, int * cap );     /* YOU WRITE THIS */
void buildReverseArray( Elem ** revArray, int *revCnt, int *revCap, Elem *array, int cnt );  /* YOU WRITE THIS */
void freeArray( Elem **array, int * cnt, int * cap );  /* YOU WRITE THIS */
void buildArray(  char * infileName, Elem **array, int *cnt, int * cap ); /* GIVEN AS-IS. DO NOT EDIT */
void printArray( char * msg, Elem *array, int cnt ); /* GIVEN AS-IS. DO NOT EDIT */
void fatal( char * msg );  /* GIVEN AS-IS. DO NOT EDIT */

int main( int argc, char **argv )
{
	Elem * array = malloc( INITIAL_CAPACITY * sizeof(Elem) );
	int cnt=0,cap=INITIAL_CAPACITY;

	Elem * revArray = NULL;
	int revCnt=0,revCap=0;

	if (argc<2)
	{
		printf("usage: %s <inputFile1>",argv[0]);
		exit(0);
	}

	buildArray( argv[1], &array, &cnt, &cap  );
	printArray( "ORIGINAL ARRAY: ", array, cnt );

	buildReverseArray( &revArray, &revCnt, &revCap, array, cnt );
	printArray( "REVERSED ARRAY: ", revArray, cnt );

	freeArray( &array, &cnt, &cap );
	freeArray( &revArray, &revCnt, &revCap );

	printArray( "\nFREED ORIGINAL ARRAY: ",  array, cnt );
	printArray( "FREED REVERSAL ARRAY: ", array, cnt );

	return 0;
} /* END MAIN */

/* ===============================================================================*/
/* .........................YOU FILL IN THE NEXT 3 FUNCTIONS .....................*/
/* ===============================================================================*/

/* Be sure to zero out cnt, cap and NULL the array ptr */
void freeArray( Elem **array, int * cnt, int * cap )
{
	/* YOUR CODE HERE */
}

/* YOU are responsible to resize as needed. Just like lab2.
	DO not hardcode a big initial cpacity to avoid resize
   except while testing of course.  But we will test with initial cap = 2
*/
void insertInOrder( Elem **array, char * word, int * cnt, int * cap )
{
	/* YOUR CODE HERE      just like lab #2 :=)   */
}

void buildReverseArray( Elem ** revArray, int *revCnt, int *revCap, Elem *array, int cnt )
{
	/* YOUR CODE HERE */
}


/* GIVEN AS IS. DO NOT MODIFY */

void buildArray(  char * infileName, Elem **array, int *cnt, int * cap )
{
	char *word;
    FILE* infile = fopen(infileName, "r");
    if (!infile)
    {
        printf("Could not open file %s!\n", infileName);
        exit(-1);
    }
    /* read words until EOF */

    while ( fgetline_123(&word, infile ))
    {
        insertInOrder( array, word, cnt, cap );
    }
    free(word);
	fclose( infile );
}

void printArray( char * msg, Elem *array, int cnt )
{
	int i=0;
	printf("%s " , msg );
	for ( ; i<cnt ; ++i)
		printf("%s ",array[i].word);
	printf("\n");
}

void fatal( char * msg )
{
	printf("\nFatal Error: %s\n\n", msg );
	exit(0);
}
