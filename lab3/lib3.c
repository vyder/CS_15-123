#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "getline.h"
#include "lab-03-lib.h"

/* menu function, runs an infinite while loop to display options for the user*/
void menu( char **dictionary, int *count, char * outfilname, int *cap )
{
	while (1)
	{
		char option;
		int found = 0;
		
		printf("\nChoose: 'P'rint, 'S'earch, 'I'nsert, 'R'emove, 'C'ount, 'Q'uit : ");
		fflush( stdout );
		fscanf(stdin, " %c%*[^\n]", &option );
		getchar(); /* eat the newline from the kbd buffer */
		
		if (option=='Q' || option =='q' )
		{
			/* open an output file and pass the open file handle into printDictionary */
			FILE * outfil = fopen( outfilname, "wt" );
			if (!outfil)
			{
				exit( EXIT_FAILURE );
			}
			printDictionary( outfil, dictionary, *count );
			printf("EXITING PROGRAM - WORDS SAVED TO %s\n", outfilname );
			freeAllMemory(&dictionary, *count);
			fclose(outfil);
			exit( EXIT_SUCCESS );
		}
		else if (option=='P' || option =='p' )
		{
			printDictionary( stdout, dictionary, *count );
		}
		else if (option == 'C' || option == 'c')
		{
			printf("wordCount is: %d", *count);
			fflush(stdout);
		}
		else if (option == 'S' || option == 's')
		{
			char *search;
			int result;
			printf("\nSearch for: ");
			fflush( stdout );
			fgetline_123 ( &search, stdin );
			result = bSearch(dictionary, *count, search, &found);
			if(found)
				printf ("%s FOUND at INDEX %d.", search, result);
			else
				printf("%s not found.", search);
			free(search);
		}
		else if(option == 'I' || option == 'i')
		{
			char *iWord;
			printf("\nEnter word to insert: ");
			fflush( stdout );
			fgetline_123 ( &iWord, stdin );
			insert(&dictionary, iWord, count,cap);
			
		}
		else if(option == 'R' || option == 'r')
		{
			char *rWord;
			printf("\nWord to be removed: ");
			fflush( stdout );
			fgetline_123 ( &rWord, stdin );
			removeW(dictionary, count, rWord);
			free(rWord);
		}
	}
}

/* this method sets up the dictionary, reads from a text file, and then uses the insert method to insert all the read words one at a time */	
void load( char * filename, char ***dictionary, int * count, int * cap )
{
  char *buffer;
  FILE *infile;
  infile =fopen(filename,"rt");
  if (!infile) exit(0);

  while ( fgetline_123( &buffer, infile ))
  {
	  insert(dictionary,buffer, count,cap);
  }
  fclose( infile );
}

/* this method prints out the dictionary in alphabetical order, compliant to the specified formatting rules */
void printDictionary(  FILE * outputStream, char **dictionary, int count )
{
	int i;
	int linecount = 0;
	for( i=0 ; i<count ; ++i )
	{
		int stringlength = strlen(dictionary[i]);
		if(stringlength + linecount < 80)
		{
			fprintf( outputStream, "%s ", dictionary[i] ); 
			linecount = linecount + 1 + stringlength;
		}
		else
		{
			fprintf( outputStream, "\n%s ", dictionary[i] );
			linecount = stringlength + 1;
		}
	}
}


/* this method takes a string and inserts it at its correct position in a string array, and increases the count by 1 */
void insert( char ***dictionary, char * wordBuffer, int * count, int *cap )
{
    int i;
    int found = 0;
	
	int index = bSearch(*dictionary, *count, wordBuffer, &found);
	if(found == 1)
	{
		printf("Word '%s' already exists, cannot enter it into the dictionary",wordBuffer);
		free(wordBuffer);
		return;
	}
	if (*count>=*cap)
	{ 
		  resizeDictionary(dictionary,cap);

	}
	if(*count == 0)
    {
        **dictionary = wordBuffer;
    }
    else
    {
		for( i = *count -1; i >= -index; i--)
		{
			(*dictionary)[i+1] = (*dictionary)[i];
		}
		(*dictionary)[-index] = wordBuffer;
	}
    ++(*count);
	
}

/* this method is effectively a replacement for a realloc, mallocs a new array, copies elements from the old array and then free its original memory and makes it point to the new array */
void resizeDictionary( char ***dictionary, int *capacity)
{
	int i;
	char **myAwesomeNewDictionary = malloc( *capacity * 2 * sizeof(char *) );
	for(i=0; i<*capacity; i++)
	{
		myAwesomeNewDictionary[i] = (*dictionary)[i];
	}
	free(*dictionary);
	*dictionary = myAwesomeNewDictionary;
	*capacity *= 2; 
}

/* frees all remaining memory at the end of the program */
void freeAllMemory(char ***dictionary, int count)
{
	int i;
	for(i=0 ; i< count ; ++i)
	  free( (*dictionary)[i] );
	free( *dictionary );
}

/* method removes a word from the dictionary array and reduced the count variable by 1 */
void removeW(char **dictionary, int *count, char *rWord)
{
	int found = 0;
	int index = bSearch(dictionary, *count, rWord, &found);
	if(found == 0)
	{
		printf("Can't find word");
	}
	else
	{
		int i;
		free(dictionary[index]);
		for(i=index+1; i<(*count); i++)
		{
			dictionary[i-1] = dictionary[i];
		}
		(*count)--;
		printf("%s removed.", rWord);
	}
}

/* modified binary search , returns index if word found, returns negative of position the word should belong to if it does not exist in the array*/
int  bSearch( char ** dictionary, int count, char *word, int *found )
{
	int mid;
	int low = 0;
	int high = count - 1;
	while(low <= high)
	{
		mid = (low + high)/2;
		
		if( strcmp(word,dictionary[mid]) >  0 )
		{	
			low = mid + 1;
		}
		else if(strcmp(word,dictionary[mid]) < 0)
		{
			high = mid - 1;
		}
		else
		{
			*found = 1;
			return mid;
		}
	}
	return -(low);
}
