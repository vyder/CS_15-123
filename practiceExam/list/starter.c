/*
	starter.c for Linked List version of the REVERSAL  problem
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

}
void insertAtFront( Elem **list, char * word )
{
	ELEM *new =malloc( sizeof(ELEM) );
	new->word=word;
	new->next=*list;
	*list=new;
}
void removeAtFront( Elem ** list )
{
	if( *list==NULL)
		return;
	ELEM *deadElem = *list;
	*list=*list->next;
	free(deadElem->word);
	free(deadElem);
}
void insertInOrder( Elem **list, char * word )
{
	if( strcmp(*list->word,word)
}

void freeList( Elem **list )
{
	/* YOUR CODE HERE */
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
