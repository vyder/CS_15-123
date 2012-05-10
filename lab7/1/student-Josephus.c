#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cdll.h"
#include "getline.h"

typedef struct STUDENT
{
	char * andrewID;     /* i.e. weirdal */
	char * name;         /* i.e. Alfred Yankovic */
	int yrOfGrad;        /* i.e 2010 */
	double gpa;          /* i.e 4.0 */
	char * major;        /* i.e CS  */
} STUDENT;


void printStudent( void * data, int mode )
{
	STUDENT *s  = (STUDENT*)data;
	if (mode==BRIEF)
		printf("%s ", s->andrewID );
	else
		printf("%s %s %d %f, %s ", s->andrewID, s->name, s->yrOfGrad, s->gpa, s->major );
}

int compareStudent( void * data1, void *data2 )
{
	return strcmp( ((STUDENT *)data1)->andrewID, ((STUDENT *)data2)->andrewID ); /* Compares the andrewIDs */
}

/* Reads strings from the file into the liked list */
void loadList( CDLL *list, char *infileName)
{
/*
	Y O U R   C O D E   H E R E 
	read each line from the file one at a time
	tokenize the line (perhaps write a tokenizer like in one of our quizzes)
	using those those tokens, fill up a Student struct
	append that student onto the end of the list
	Beware to free up all memory that is not intended to be permanently stored in the list
	Beware NOT to free memory that has pointers to it stored in the list
*/

	char *inputLine;
	STUDENT *student;
	FILE* infile = fopen(infileName, "r");
	if(!infile) fatal("Can't open input file");

	while( fgetline_123( &inputLine, infile ) )
	{
		student = malloc( sizeof(STUDENT) );
		student->andrewID=strtok(inputLine, " \t");
		student->name = strtok(NULL, " \t");
		student->yrOfGrad = atoi(strtok(NULL, " \t"));
		student->gpa = atof(strtok(NULL, " \t"));
		student->major = strtok(NULL, " \t");
		insertAtTail(list,student);
	}

	fclose(infile);
}

void freeStudent(void *student)
{
	free( ((STUDENT *)student)->andrewID );
	free( (STUDENT *)student );
}


/* == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == */
int main(int argc, char *argv[])
{
	CDLL list;
	int i,direction,k;
	CDLL_NODE *currNode;

	if (argc < 4)
	{
		printf("You must supply 3 values on the cmd line after %s:\n", argv[0]);
		printf("1: name of an input file contaning n names/labels of the members of the circle\n");
		printf("2: an integer:  m < n  ,  indicating that every m'th member gets deleted until all the members are deleted\n");
		printf("3: a string \"CW\" or \"CCW\" for clockwise counter-clockwise. This is the direction\n");
		printf("   you will move as you advance around the ring deleting members\n");
		exit( EXIT_FAILURE );
	}

	k = atoi(argv[2]); /* assume valid int < n */
	if (strcmp(argv[3],"CW")==0)
		direction = CLOCKWISE; /* follow the NEXT ptr */
	else
		direction = COUNTERCLOCKWISE; /* follow the PREV ptr */

	/* Initialize CDLL (set head ptr NULL and set the cmp function */
	initList(&list,compareStudent,printStudent,freeStudent);
	loadList(&list,argv[1]);
	printList(list, CLOCKWISE, BRIEF ); /* we follow the NEXT ptr around the ring, not the PREV ptr */

	do /* prompt user for a member to start the counting with */
	{
		char *andrewID;
		STUDENT *s = malloc(sizeof(STUDENT));

		currNode=NULL;
		printf("\n\nchoose an andrewID as the starting point in the circle: ");
		fflush(stdout);
		if (!fgetline_123(&andrewID,stdin)) fatal("fgetline_123 failed on stdin.");
		s->andrewID = andrewID;
		currNode = searchList(list,s);

		/* Can't call freeStudent() because it will free the name and major string but we didnt put any in this one - this student only has the id field initilaized */

		free( s->andrewID );
		free( s );

	} while (!currNode);

	while (list.head) /* WHILE THERE ARE ANY MEMBERS STILL ALIVE */
	{
		printf("\nDELETING: "); printStudent( currNode->data, BRIEF); fflush(stdout);
		currNode = deleteNode(&list,currNode,direction);
		if (!currNode)
		{
			printf("  <-- was the last man standing!\n");
			break;
		}

		printList(list, CLOCKWISE, BRIEF );
		printf("RESUMING AT: "); printStudent( currNode->data, BRIEF ); printf(" and skipping %d elements \n", k );
		for ( i=1 ; i<=k ; ++i )
			if (direction==CLOCKWISE)
				currNode = currNode->next;
			else
				currNode=currNode->prev;

	} /* END WHILE - END OF GAME */
    return EXIT_SUCCESS;
}
