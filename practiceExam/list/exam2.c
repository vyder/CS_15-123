/*
	solution.c for Linked List version of the REVERSAL  problem
	1 input file required to be passed on cmd line
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "getline.h"

typedef struct Elem
{
	char * word;
	struct Elem *next;
} Elem;

void buildRevList(  Elem **revList, Elem * list );  /* YOU WRITE THIS */
void freeList( Elem **list );                              /* YOU WRITE THIS */
void insertAtFront( Elem **list, char * word );  /* YOU WRITE THIS */
void insertInOrder( Elem **list, char * word );     /* YOU WRITE THIS */
void buildList(  char * infileName, Elem **list ); /* GIVEN AS-IS. DO NOT EDIT */
void printList( char *msg, Elem *list );            /* GIVEN AS-IS. DO NOT EDIT */
void fatal( char * msg );                                  /* GIVEN AS-IS. DO NOT EDIT */

int main( int argc, char *argv[] )
{
	Elem * list = NULL;
	Elem * revList = NULL;


	if (argc<2)
	{
		printf("usage: %s <inputFile1>",argv[0]);
		exit(0);
	}

	buildList( argv[1], &list  );
	printList( "ORIGINAL LIST: ", list );

	buildRevList( &revList, list );
	printList( "REVERSAL LIST: ", revList );


	freeList( &list );
	freeList( &revList);


	printList( "\nFREED ORIGINAL LIST: " , list );
	printList( "FREED REVERSAL LIST: " ,revList );

	return 0;
} /* END MAIN */

/* ===============================================================================*/
/* .........................YOU FILL IN THE NEXT 3 FUNCTIONS .....................*/
/* ===============================================================================*/



void buildRevList(  Elem **revList, Elem * list )
{
	while (list)
	{
		insertAtFront( revList, list->word );
		list=list->next;
	}
}
void insertAtFront( Elem **list, char * word )
{
	Elem *new =  malloc( sizeof(Elem) );
	if (!new)  fatal("Malloc of new Elem failed");
	new->word=malloc( strlen(word)+1);
	if (!new->word) fatal("Malloc of new->word failed");
	strcpy( new->word, word );
	new->next = *list;
	*list = new;
}
void removeAtFront( Elem ** list )
{
	Elem * deadElem = *list;
	if (*list==NULL) return; /* nothing to remove */
	*list = deadElem->next;
	free( deadElem->word );
	free( deadElem );
}
void insertInOrder( Elem **list, char * word )
{
	if (*list==NULL || strcmp(word, (*list)->word) < 0   )
		insertAtFront( list, word );
	else 	if ( strcmp(word, (*list)->word) != 0 )
		insertInOrder( &(*list)->next, word );
}

void freeList( Elem **list )
{
	while (*list) removeAtFront( list );
}


/* GIVEN AS IS. DO NOT MODIFY */

void buildList(  char * infileName, Elem **list )
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
        insertInOrder( list, word );
        free( word ); /* because our insert does a DEEP copy */
    }
    free(word);
	fclose( infile );
}

/* GIVEN AS IS. DO NOT MODIFY */
void printList( char * msg, Elem *list )
{
	printf("%s  ", msg );
	while (list)
	{
		printf("%s ",list->word);
		list=list->next;
	}
	printf("\n");
}

/* GIVEN AS IS. DO NOT MODIFY */
void fatal( char * msg )
{
	printf("\nFatal Error: %s\n\n", msg );
	exit(0);
}
