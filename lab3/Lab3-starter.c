
/*	--------------------------------------------------------------------------------------------------
	myName: TIM HOFFMANs SOLUTION to Lab3 15-123 F08
	my AndrewID:  tlh@andrew.cmu.edu

*/
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> /* toupper() function and others */
#include "getline.h"  /* must have getline.h AND getline.c sitting in directory with Lab2.c */

#define INITIAL_CAPACITY 50
#define true 1
#define false 0



/* LOADDICTIONARY
   1) declare a char *newWord  or such so fgetline_123 has a pointer to give you back the addy of each word it reads in
   1) open up inFile (name sent in)
   2) while fgetsline_123 sucessfully reads a newWord from the stream
         call insertWord  // let IT do ALL the work of testing for dupes,freeing dupe if needed, incrmenting count, testing/calling resize etc etc
   3) close inFile
*/
void loadDictionary( char *infileName, char ***dictionary, int *count, int *capacity );


/* DOMENU:
	you gotta free the 'I'(if dupe) and 'R' words somewhere - Id do in the and Insert & Remove functions -  not here
        id free the 'S'earch word here though
*/

void doMenu( char *outfileName, char ***dictionary, int *count, int *capacity );

void freeAllMemory( char **dictionary, int count ); /* we discussed this in class extensively */

void resizeDictionary( char ***dictionary, int *capacity); /* we discussed this in class extensively */

void printDictionary( char ** dictionary, int count, FILE *stream ); /* we discussed this in class extensively */



/* INSERTWORD:
   you MUST pass the ADDR of the main dictionary ptr cause you have to modify that ptr every time you resize
   cause you are gonna put  addr of a NEW 2 X array into that pointer

   in here you must use syntax (*dictionary)[i]  cause (*dictionary) in here is a synonyum for dictionary in main
   Insert MUST test for dupes - EVEN coming form the the input file. If you have to reject a word then your insert function
   can have printf in here saying "%s rejected" etc.

   1) call bsearch to see if the word is a dupe - if it IS a dupe
	print rejection msg
	free the word
	RETURN (remember you must free the incoming dupe newWord either HERE or back where you called it from. Id just do it here)
   2) Check to see if you need to resize - do so if needed
   3) you already have the index where the word belongs - just shift all ptrs from that index down one slot higher.
      to open up your hole for the new word. Then copy in the new word's pointer
   4) incr count
*/
void insertWord( char ***dictionary, int *count, int *capacity, char *word );






/* REMOVE WORD
   1) call bsearch to see if the word is there to be deleted
   2) if not found then
	print "can't delete %s cause it aint here" msg or..  whatever and RETURN
OTHERWISE
   3) you have the index of where it is so call free on that  pointer
   4) now copy every pointer above the freed one down one place - i.e. close up the gap
   5) decr count

   PS you dont really need a *** passed in for this one. You are NOT going to modify the array. THerfore  a ** passed in will do just fine
   I have a *** cause I wrote mine to be able to downsize the array if more than half the array got deleted. Don't worry about this.
   Your solution does not do downsizing so it does not really need a *** passed in.
*/

void removeWord( char ***dictionary, int *count, char *word );




/* BSEARCH:
   sets found to true (1) /false (0).
   If found comes back true then the index is where the word IS
   If found comes back false then index is where word BELONGS
*/

int  bSearch( char ** dictionary, int count, char *word, int *found ); /* sets found to true (1) /false (0).


/*    M A I N   F U N C T I O N  */

int main( int argc, char *argv[] )
{
	time_t startTime, stopTime;
	clock_t startCPU, stopCPU;
	double elapsedCPUsecs;
	int capacity = INITIAL_CAPACITY;
	int count =0;
	char **dictionary = malloc( capacity * sizeof(char *) );
	if (dictionary == NULL )
	{
		printf("Initial malloc of dictionary failed. Program exiting\n");
		return EXIT_FAILURE; /* EXIT_FAILURE defined as non zero in stdlib.h */
	}

	if (argc < 3 )
	{
		printf("usage: ./%s <infileName> <outFilename>\n",argv[0]); /* you gotta put in & out file names on cmd line! */
		return EXIT_FAILURE;
	}

	startTime = time( NULL );
	printf("\nStarting load of %s at %s", argv[1], ctime( &startTime) );
	printf("each '*' represents 10,000 words loaded into dictionary\n");
	startCPU = clock();
	loadDictionary( argv[1], &dictionary, &count, & capacity );
	stopCPU = clock();
	stopTime = time( NULL );
	printf("\nFinished load of %s at %s", argv[1], ctime( &stopTime) );
	printf("%d words loaded in %lu seconds\n", count, stopTime-startTime );
	elapsedCPUsecs = ((double)(stopCPU-startCPU)) / CLOCKS_PER_SEC;
	printf("Elapsed CPU seconds: %f\n",  elapsedCPUsecs );
	doMenu( argv[2], &dictionary, &count, &capacity );
	freeAllMemory( dictionary, count );

	return EXIT_SUCCESS; /* EXIT_SUCCESS defined as 0 in stdlib.h */
}


