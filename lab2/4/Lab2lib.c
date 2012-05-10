/* Lab2lib.c */

#include "Lab2lib.h"

void menu( char dictionary[][MAX_WORDLEN], int *count, char *outfilname)
{
	while(1)
	{
	        int index;
		char option;
		char word[MAX_WORDLEN];
		printf("\nChoose: 'Q'uit 'S'earch 'I'nsert 'R'emove 'C'ount 'P'rint: ");
		fflush( stdout );
		fscanf( stdin, " %c%*[^\n]", &option );
		getchar(); /*eat the newline*/
		
		if (option=='Q' || option =='q' )
		{
			/*open an output file and pass the open file handle into printDictionary */
			FILE *outfil = fopen( outfilname, "wt" );
			if (!outfil)
			{
				exit(EXIT_FAILURE);
			}
			printDictionary( outfil, dictionary, *count );
			printf("EXITING PROGRAM - WORDS SAVED TO %s\n", outfilname );
			exit( EXIT_SUCCESS );
		}
		else if (option=='P' || option == 'p' )
		{
			printDictionary(stdout, dictionary, *count);
		}
		else if (option=='s' || option == 'S' )
		  {
		    printf("\nEnter word to be searched: ");
		    fflush( stdout );
		    scanf( "%s", word);
		    if(searchWord(dictionary, word, *count) != 0 ) 
		      { 
			printf("\n%s found", word); 
		      } 
		    else 
		      printf("\n%s NOT found", word); 

		  }
		else if (option=='i' || option == 'I' ) 
                  { 
                    printf("\nEnter word to be inserted: "); 
                    fflush( stdout ); 
                    scanf( "%s", word);
		    if(searchWord(dictionary, word, *count) == 0) 
		      { 
			insert( dictionary, word, count ); 
			printf("\n%s inserted", word); 
		      } 
		    else 
		      printf("\n%s ignored (duplicate)", word);  
                  }
		else if (option=='r' || option == 'R' )  
                  {  
                    printf("\nEnter word to be removed: ");  
                    fflush( stdout );  
                    scanf( "%s", word); 
		    index = searchWord(dictionary, word, *count);
                    if(index != 0)  
                      {  
                        removeWord( dictionary, word, count, index );  
                        printf("\n%s removed", word);  
                      }  
                    else  
                      printf("\n%s ignored (not found)", word);   
                  }
		else if (option=='c' || option == 'C' ) 
		  { 
		    printf("\nNumber Count: %d", *count); 
		  } 
	}
}

void loadDictionary( char *infilname, char dictionary[][MAX_WORDLEN], int *count )
{
	FILE *infile;
	char wordBuffer[MAX_WORDLEN];
	infile = fopen( infilname, "rt" );
	if (!infile)
	{
		printf("Cant open %s for input\n", infilname );
		exit(EXIT_FAILURE);
	}
		
   	while ( fgets(wordBuffer, MAX_WORDLEN, infile )  )  /* when fgets hits EOF it will return NULL */
   	{
		removeNewln( wordBuffer );  /* replace \n with \0 */
		insert( dictionary, wordBuffer, count );
   	}
  	/* EOF reached. close file */
   	fclose( infile );
}

void removeNewln( char wordBuffer[MAX_WORDLEN] )
{
	int i;
	for( i =0; wordBuffer[i]!='\n'; i++);
	wordBuffer[i] = '\0';
}

void insert( char dictionary[][MAX_WORDLEN], char * wordBuffer, int * count )
{
        int i;
	if(*count == 0)
	  {
	    strcpy(dictionary[0],wordBuffer);
	  }
	else
	  {
	    for ( i = *count; i> 0 ; --i)
	      {
		if(strcmp(dictionary[i-1],wordBuffer) == 0)
		  return;
		else if(strcmp(dictionary[i-1],wordBuffer) > 0)
		  strcpy(dictionary[i],dictionary[i-1]);
		else if(strcmp(dictionary[i-1],wordBuffer) < 0)
		  break;
	      }
	    strcpy(dictionary[i],wordBuffer);
	  }
	++(*count);
}


void printDictionary( FILE * outputStream, char dictionary[][MAX_WORDLEN], int count )
{
  int i, j, charCount = 0;
  for( i=0; i<count; ++i )
  {
    for( j=0; dictionary[i][j] != '\0'; j++);
    charCount += j; /*number of characters in current word + 1 for space character */
    if( charCount < 79 )
      {
	fprintf( outputStream, "%s ", dictionary[i] );
      }
    else 
      {
	fprintf( outputStream, "\n%s ", dictionary[i] );
	charCount = j;
      }
   }
}

int searchWord( char dictionary[][MAX_WORDLEN], char *  word, int count )
{
  int res = 0, i;
  for( i =0; i < count; i++)
    {
      if(strcmp(dictionary[i],word) == 0)
	res = i;
    }
  return res;
}

void removeWord( char dictionary[][MAX_WORDLEN], char * word, int * count, int index )
{
  int i;
  for(i=index; i < (*count)-1 ; i++)
    {
      strcpy(dictionary[i],dictionary[i+1]);
    }
  (*count)--;
}

