#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cdll.h"

/* just a convenience */
void fatal( char * msg )
{
	printf("%s\n",msg);
	exit(EXIT_FAILURE);
}


/* ----------------------------------------------------------------------------
	initList:

*/
void initList(CDLL *list, int (*compare)(void*, void*), void (*print)(void*, int), void (*freeData)(void *))
{
	/* Y O U R   C O D E    H E R E */
	/* 1) set the head pointer in the CDLL struct to NULL */
	list->head=NULL;

	/* 2) assign each of the incoming function pointers into their respective fields in the CDLL struct */
	list->compare=compare;
	list->print=print;
	list->freeData=freeData;
}


/* ----------------------------------------------------------------------------
	insertAtTail:

	wrap the incoming data value in a CDLL_NODE and append that node onto list
	You don't need iteration ANYWHERE in this code.

*/
void insertAtTail(CDLL *list, void *data)
{
	int i,j;
	CDLL_NODE *new = malloc( sizeof(CDLL_NODE) );
	new->data=data;
	new->next=list->head;
	new->prev=(list->head)->prev;
	new->prev->next=new;
	new->next->prev=new;
}



/* ----------------------------------------------------------------------------
	deleteNode:

	Scan list until you find a node that contains the data value passed in.
	Delete that node then return the pointer to it's successor (if CW) or
	of you are going CCW then return pointer to the deadNode's predecessor.
	IF deadnode was the last node then return NULL since there is no succ or pred.

	If no match is found you are responsible to correctly free the element passed
	in since it is NOT permanent as ws only created for the search.

*/
CDLL_NODE * deleteNode(CDLL *list, CDLL_NODE *deadNode, int direction )
{
	CDLL_NODE *current=list->head;

	do
	{
		if( current == deadNode )
		{
			deadNode->next->prev=deadNode->prev;
			deadNode->prev->next=deadNode->next;
			
			if( direction == 1 )
				current=deadNode->next;
			else
				current=deadNode->prev;
			
			free(deadNode->data);
			free(deadNode);
			
			return current;
		}
		current=current->next;

	}while( current != list->head );
	
	free(deadNode->data);
	free(deadNode);

	return NULL;
}



/* Observe my solution executable to see how it should look

	You are really just writing the loop etc. becasue the
	printData's are already written and they are the hardest part
*/

void printList( CDLL list, int direction, int mode )
{
	CDLL_NODE *current=list.head;
	void (*print)(void*, int);
	
	print=list.print;
		
	do
	{
		print(current->data,mode);
		if( direction == 1 )
			current=current->next;
		else
			current=current->prev;
	}while( current != list.head );
}



/* ----------------------------------------------------------------------------
	searchList:

	Scan list until you find a node that contains the data value passed in.
	If found return that pointer - otherwise return NULL


*/
CDLL_NODE * searchList( CDLL list, void * target )
{
	CDLL_NODE *current=list.head;
	int (*compare)(void*, void*);
	
	compare=list.compare;
	
	do
	{
		if( compare(current->data,target) == 0 )
		{
			return current;
		}
		current=current->next;
		
	}while(current != list.head );

	return NULL;
}
