/*
   QUIZ#6

   FILL IN AND TEST ALL THESE FUNCTIONS PROTOTYPED BELOW
   SEVERAL ARE ALREADY FILED IN such as insertAtFront() and printList(), fatal, etc.

RUBRIK:

worth 10% searchNode - we wrote it in class together!
worth 10% insertAtTail  - MUST RE_USE insertAtFront - we wrote it in class today
worth 20% copyOf - HINT...RE_USE insertAtTail
worth 40% removeNode - MUST RE_USE removeAtFront
worth 20% reversalOf - MUST RE_USE insertATFront

freeing all memory correctly before exit worth 5% X/C
rejucting duplicates worth 5% X/C
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "getline.h"

typedef struct Node
{
  char  *word;
  struct Node  *next;
} Node;


Node *searchNode( Node * head, char * key );
void insertAtFront( Node **head, char * key );
void insertAtTail( Node **head, char * key );
void removeAtFront( Node ** head );
void removeNode( Node **head, char * key );
Node * copyOf( Node *head ); /* return head ptr to a DEEP copy of this list, Does NOT modify list passed in*/
Node * reversalOf( Node * head ); /* return head ptr to DEEP copy reversal of list. Does NOT modify list passed in*/
void printList( Node * head );
void fatal( char * msg );

int main( int argc, char *argv[])
{
	Node *head = NULL;

	while (1)
	{
		char option;
		char * word;

		printf("\nChoose 'H'ead Insert, 'T'ail insert, 'R'emove, 'S'earch, re'V'ersal, co'P'y, 'Q'uit " );
		fflush( stdout );
		scanf(" %c%*[^\n]", &option); getchar();

		if (option == 'H' )
		{
			printf("Enter a word to insertAtFront: " );
			fflush( stdout );
			fgetline_123( &word, stdin );
			insertAtFront( &head, word ); /* shallow copy string into list   */
			printList( head );
		}
		if (option == 'T' )
		{
			printf("Enter a word to insertAtTail: " );
			fflush( stdout );
			fgetline_123( &word, stdin );
			insertAtTail( &head, word ); /* shallow copy string into list   */
			printList( head );
		}
		if (option == 'R' )
		{
			printf("Enter a word to remove: " );
			fflush( stdout );
			fgetline_123( &word, stdin );
			removeNode( &head, word );
			free( word ); /* this is NOT the word in the list - it needs freed separately !!*/
			printList( head );
		}
		if (option == 'S' )
		{
			printf("Enter a word to find: " );
			fflush( stdout );
			fgetline_123( &word, stdin );
			if (searchNode( head, word ))
				fprintf(stderr, "%s FOUND\n",word );
			else
				fprintf(stderr, "%s NOT FOUND\n",word );
			free( word );
			printList( head );
		}
		if (option == 'V' )
		{
			Node *revsHead = reversalOf( head ); /* DO NOT MODIFY ORIG LIST! */
			printf("\nCreating and Printing a DEEP reversal of curr list\n" );
			printList( revsHead );

		}
		if (option == 'P' )
		{
			printf("\nCreating and Printing a DEEP copy of curr list\n" );
			Node *copysHead = copyOf( head ); /* DO NOT MODIFY ORIG LIST! */
			printList( copysHead );
		}
		else if (option == 'Q' )
			exit( 0 );
	}
	return 0;
}

Node * searchNode ( Node * head, char * word )
{
	if( head == NULL )
		return NULL;
	else if( strcmp(head->word,word) == 0)
		return head;
	else
		return searchNode( head->next, word);
}

void insertAtFront( Node **head, char * key )
{
	Node *new =  malloc( sizeof(Node) );
	if (!new)  fatal("Malloc of new Node failed");
	new->word = key;
	new->next = *head;
	*head = new;
}
void insertAtTail( Node **head, char * word )
{
	if( **head == NULL )
	{
		insertAtFront(*head,word);
	}
	else if( *head->next == NULL )
	{
		Node *new;
		*head->next=new;
		insertAtFront(new,word);
	}
	else
	{
		insertAtTail(*head->next,word);
	}
}
void removeAtFront( Node ** head )
{
	**head=**head->next;
}

void removeNode( Node ** head, char * key )
{
	/* re-use removeAtFront */
}

Node * copyOf( Node *head )
{
	/* your code here */
	/* make a deep copy of each  string- you dont want list2's nodes pointing at list1's strings */
	return NULL; /* you dont really return null necessarily - its just here to compile */
}
Node * reversalOf( Node * head )
{
	/* your code here */
	/* make a deep copy of each  string- you dont want list2's nodes pointing at list1's strings */
	return NULL;  /* you dont really return null necessarily - its just here to compile */
}

void printList( Node * head )
{
    fprintf(stderr, "\nLIST: ");
    while (head)
    {
        fprintf(stderr, "%s ", head->word );
        head=head->next;
    }
    fprintf(stderr, "\n");
}

void fatal( char * msg )
{
	printf("\nFatal Error: %s\n\n", msg );
	exit(0);
}
