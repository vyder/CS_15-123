#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cdll.h"



/* 	---------------------------------------------------------------------------
	printInt

	given already written so you see how/where/why to cast
*/
void printInt( void * data, int mode )
{
	mode=mode;  /* just to shut up the compiler warning about unused arg */
	printf("%d ", (int)data ); /* NOTE: we MUST cast */
}




/*	---------------------------------------------------------------------------
	compareInt: (like strcmp)

	If data1 > data2  returns an int > 0
	If data1 < data2  returns an int < 0
	If they are equal returns 0
*/
int compareInt( void * data1 , void *data2 )
{
	int *num1=(int *)data1,*num2=(int *)data2;
	
	return (*num1-*num2);
}





/*	---------------------------------------------------------------------------
	freeInt: a no brainer
	Think about it - did we ever malloc any memory to store this int?
*/
void freeInt(void *data)
{
	data=NULL;
}



/*	---------------------------------------------------------------------------
	loadList:

	loops from lo value to hi value (from cmd args) appending each int value
	onto the end of the list. DO NOT MALLOC MEMORY FOR THE INT TO BE STORED
	- INSTEAD STORE IT 	*INSIDE* THE DATA POINTER (again..casting!)
*/
void loadList( CDLL *list, int lo, int hi)
{
	int *data=&lo;
	insertAtTail(list,data);
	while(lo!=hi)
	{
		++lo;
		*data=lo;
		insertAtTail(list, data);
	}
}

/* == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == */
int main(int argc, char *argv[])
{
	CDLL list;
	int i,direction, k;
	CDLL_NODE *currNode;

	if (argc < 5)
	{
		printf("You must supply 4 values on the cmd line after %s:\n", argv[0]);
		printf("1: A lowest int value to start the list at.\n");
		printf("2: A highest int value to end the list at.\n");
		printf("3: an integer:  k < hi-lo+1),  indicating that after deleting the selected starting element, k members are skipped before another deletions until all the members are deleted\n");
		printf("4: a string \"CW\" or \"CCW\" for clockwise counter-clockwise. This is the direction\n");
		printf("   you will move as you advance around the ring deleting members\n");
		exit( EXIT_FAILURE );
	}

	k = atoi(argv[3]); /* assume valid int < n */
	if (strcmp(argv[4],"CW")==0)
		direction = CLOCKWISE; /* follow the NEXT ptr */
	else
		direction = COUNTERCLOCKWISE; /* follow the PREV ptr */

	/* Initialize CDLL (set head ptr NULL and set the cmp function */
	initList(&list,compareInt,printInt,freeInt);
	loadList(&list,atoi(argv[1]),atoi(argv[2]));
	printList(list, CLOCKWISE, BRIEF ); /* we follow the NEXT ptr around the ring, not the PREV ptr */

	do /* prompt user for a member to start the counting with */
	{
		int n;
		currNode=NULL;
		printf("\nenter an int  as the starting point in the circle: ");
		fflush(stdout);
		scanf("%d",&n);

		currNode = searchList(list,&n);
	} while (!currNode);

	while (list.head)
	{
		printf("\nDELETING: "); printInt( currNode->data, BRIEF); fflush(stdout);
		currNode = deleteNode(&list,currNode,direction);
		if (!currNode)
		{
			printf("  <-- was the last man standing!\n");
			break;
		}

		printList(list, CLOCKWISE, BRIEF );
		printf("RESUMING AT: "); printInt( currNode->data, BRIEF ); printf(" and skipping %d elements \n", k );
		for ( i=1 ; i<=k ; ++i )
			if (direction==CLOCKWISE)
				currNode = currNode->next;
			else
				currNode=currNode->prev;

	} /* END WHILE - END OF GAME */

    return EXIT_SUCCESS;
}
