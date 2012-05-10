/*	--------------------------------------------------------------------------------------------------
	myName:
	my AndrewID:

	                       R E A D     T H I S      C A R E F U L L Y

	Compile this file as follows on your terminal's command line:

		gcc -ansi -pedantic -W -Wall Lab2.c getline.c -o

    	Note: you MUST compile getline.c on the command line with the main file

	Execute this file as follows on your terminal's command line:

		./a.out infilename outfilename

		Note - you MUST enter the names of the input and output files on the cmd line when you execute
	---------------------------------------------------------------------------------------------------
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> /* toupper() function and others */
#include "getline.h"  /* must have getline.h AND getline.c sitting in directory with Lab2.c */

#define INITIAL_CAPACITY 50



/*    F U N C T I O N   P R O T O T Y P E S   */

void loadDictionary( char *infileName, char ***dictionary, int *count, int *capacity );
void doMenu( char *outfileName, char ***dictionary, int *count, int *capacity );
void freeAllMemory( char **dictionary, int count );
void resizeDictionary( char ***dictionary, int *capacity);
void printDictionary( char ** dictionary, int count, FILE *stream );
void insertWord( char ***dictionary, int *count, int *capacity, char *word );
int  indexOfWord( char **dictionary, int count, char *word );

/*    M A I N   F U N C T I O N  */

int main( int argc, char *argv[] )
{
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

	loadDictionary( argv[1], &dictionary, &count, & capacity );

	doMenu( argv[2], &dictionary, &count, &capacity );

	freeAllMemory( dictionary, count );

	return EXIT_SUCCESS; /* EXIT_SUCCESS defined as 0 in stdlib.h */
}



/*    F U N C T I O N   B O D I E S  */


void loadDictionary( char *infileName, char ***dictionary, int *count, int *capacity )
{
	FILE *infile = fopen( infileName, "r" );
	char * word;

	if (infile == NULL)
	{
		printf("Can't open infile: %s. Program exiting\n",infileName );
		exit( EXIT_FAILURE );
	}

	while( fgetline_123( &word, infile) != NULL )
	{
		insertWord( dictionary, count, capacity, word );
	}
	fclose( infile );

} /* END LOAD */

void insertWord( char ***dictionary, int *count, int *capacity, char *word )
{
	if (*count == *capacity) /* need to double my array's capacity! */
			resizeDictionary( dictionary, capacity );

	(*dictionary)[*count] = word; /* copy ptr to end of dictionary array */
	++(*count);
}

void doMenu( char *outfileName, char ***dictionary, int *count, int *capacity )
{
	while ( 1 )
	{
		char choice;
		
		printf("\nChoose: 'P'rint, 'S'earch, 'I'nsert, 'R'emove, 'C'ount, 'Q'uit:  ");
		fflush( stdout );

		scanf(" %c%*[^\n]", &choice); getchar(); 
		
		

		choice = toupper( choice );

		if (choice == 'Q')
		{
			/* Write the dictionary to whatever text file user entered as last arg on cmd line.
			   Write outfile using same function as print to screen. just pass a diferent stream
			   arg to your function. Thus the format is identical. DONT WRITE 2 different functions
			   for output to screen vs. output to final text file
			*/
			return; /* back to main to free memory then exit */
		}
		else if (choice == 'P')
		{
			printDictionary( *dictionary, *count, stdout );

		}
		else if (choice == 'S')
		{
			char *word;
			printf("Enter word to find: ");
			fflush( stdout );
			if ( fgetline_123( &word, stdin ) == NULL )
			{
				printf( "fgetline failed on stdin. Prgram exiting\n" );
				exit( EXIT_FAILURE );
			}
			if ( indexOfWord( *dictionary, *count, word ) < 0 )
				printf("%s NOT found\n",word );
			else
				printf("%s FOUND\n",word );

			free(word);
		}
	} /* END while(1) */
}

void freeAllMemory( char **dictionary, int count )
{
	/* visit every string pointer in the dictionary array and free it  */
	/* free the dictionary pointer itself */
}

void resizeDictionary( char ***dictionary, int *capacity)
{
	printf("Resize not implemented yet..have to abort program at %d words\n", *capacity);
	exit(EXIT_FAILURE);
}

/* Prints the dictionary to whatever text stream has been passed in */
/* Stream is assumed to have been opened and ready for writing */

void printDictionary( char ** dictionary, int count, FILE *stream )
{
	int i;
	/* this print is not formatted to Lab2 specs. It is just a dump with a space between words.
	   Your Lab2 print must format as 80 chars per line max with one space between each word
	*/

	for (i=0 ; i<count ; ++i )
		printf("%s ", dictionary[i] );
	printf("\n");
}

/* return index where found othewise a negative value to indicate not found */

int indexOfWord( char ** dictionary, int count, char *word )
{
	int i;
	for(i=0 ; i<count ; ++i)
		if ( strcmp(dictionary[i],word) == 0 )
			return i;

	return -1;
}
