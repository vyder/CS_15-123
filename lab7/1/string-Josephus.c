#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cdll.h"
#include "getline.h"

/* 	---------------------------------------------------------------------------
	printString

	given already written so you see how/where/why to cast
*/
void printString( void * data, int mode )
{
	mode=mode;
	printf("%s ", (char*)data);
}





/*	---------------------------------------------------------------------------
	compareInt: (think strcmp and code re-use)

*/
int compareString( void * data1, void *data2 )
{
	return strcmp((char *)data1,(char *)data2);
}



/* 	---------------------------------------------------------------------------
	loadList: Reads strings from the file into the liked list


*/
void loadList( CDLL *list, char *infileName)
{
	char *name;
	FILE* infile = fopen(infileName, "r");
	if(!infile) fatal("Can't open input file");

	while( fgetline_123( &name, infile ) )
		insertAtTail(list,name);

	fclose(infile);
}




/*	---------------------------------------------------------------------------
	freeString:

*/
void freeString(void *data)
{
	free((char *)data);
}

/* == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == */
int main(int argc, char *argv[])
{
	CDLL list;
	int i,direction, k;
	CDLL_NODE *currNode;

	if (argc < 4)
	{
		printf("You must supply 3 values on the cmd line after %s:\n", argv[0]);
		printf("1: name of an input file contaning n names/labels of the members of the circle\n");
		printf("2: an integer:  k < n  ,  indicating that after deleting the selected starting element, k members are skipped before another deletions until all the members are deleted\n");
		printf("3: a string \"CW\" or \"CCW\" for clockwise counter-clockwise. This is the direction\n");
		printf("   you will move as you advance around the ring deleting members\n");
		exit( EXIT_FAILURE );
	}

	k  = atoi(argv[2]); /* assume valid int < n */
	if (strcmp(argv[3],"CW")==0)
		direction = CLOCKWISE; /* follow the NEXT ptr */
	else
		direction = COUNTERCLOCKWISE; /* follow the PREV ptr */

	/* Initialize CDLL (set head ptr NULL and set the cmp function */
	initList(&list,compareString,printString,freeString);
	loadList(&list,argv[1]);
	printList(list, CLOCKWISE, BRIEF ); /* we follow the NEXT ptr around the ring, not the PREV ptr */

	do /* prompt user for a member to start the counting with */
	{
		char *name;;
		printf("\nchoose a name as the starting point in the circle: ");
		fflush(stdout);
		if (!fgetline_123(&name,stdin)) fatal("fgetline_123 failed on stdin.");
		currNode = searchList(list,name);
		free( name );
	} while (!currNode);

	while (list.head) /* while list has any members left */
	{
		printf("\nDELETING: "); printString( currNode->data, BRIEF); fflush(stdout);
		currNode = deleteNode(&list,currNode,direction);
		if (!currNode)
		{
			printf("  <-- was the last man standing!\n");
			break;
		}

		printList(list, CLOCKWISE, BRIEF );
		printf("RESUMING AT: "); printString( currNode->data, BRIEF ); printf(" and skipping %d elements \n", k );
		for ( i=1 ; i<=k ; ++i )
			if (direction==CLOCKWISE)
				currNode = currNode->next;
			else
				currNode=currNode->prev;

	} /* END WHILE - END OF GAME */
    return EXIT_SUCCESS;
}
