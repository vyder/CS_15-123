#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "getline.h"

/*  R E A D    T H I S   A N D    F O L L O W    I T

	BE SURE TO DOWNLOAD getline.c and getline.h from http://www.cs.cmu.edu/~thoffman/S09-15123/getline
	Place them in the same directory as this main program
	compile as follows:  gcc -ansi -pedantic -W -Wall quiz-3-main.c getline.c
*/

char * mygetline( char **buffer, FILE * infile );
int endOfLine( char * buffer );

int main( int argc, char *argv[] )
{
  FILE * infile;
  char *buffer;
  if (argc<2)
  {
      printf("usage: argv[0] <input filename>\n");
      exit( EXIT_FAILURE);
  }
  infile=fopen( argv[1], "rt" );
  if (!infile)
  {
      printf("Can't open %s for input\n", argv[1]);
      exit( EXIT_FAILURE);
  }

  while( mygetline( &buffer, infile ))
  {
      unsigned int i;  /* cause it gets compared to strlen which returns an unsigned */
      printf("\n%s\n", buffer);
      for (i=0 ; i<strlen(buffer) ; ++i)
	printf("[%d] %c\n",i, buffer[i]);
      free(buffer);
  }

  fclose(infile);
  return (EXIT_SUCCESS);

}



 /* AFTER TESTING AS IS - REMOVE THE CALL TO FGETLINE_123 AND WRITE YOUR OWN CODE */

 char * mygetline( char **buffer, FILE * infile )
 {
	 int initialBufferCap=5;
	 int isEndOfLine=0;
	 int currBufferCap=initialBufferCap;
	 *buffer=malloc( initialBufferCap );
	 if (!buffer)
	 {
		 printf("\nInitial malloc of buffer failed\n");
		 exit(EXIT_FAILURE);
	 }
	 
	 if(feof(infile))
	 	return NULL;
	 **buffer = '\0';
	 
	 while( !feof(infile) && isEndOfLine!=1 )
	 {
	 	fgets( *buffer+strlen(*buffer), currBufferCap-strlen(*buffer),infile );
	 	isEndOfLine = endOfLine(*buffer);
	 	
	 	if( !feof(infile) && isEndOfLine!=1 )
	 	{
	 		currBufferCap*=2;
	 		*buffer=realloc( *buffer, currBufferCap );
		 	if(!*buffer)
		 	{
		 		printf("\nmalloc of buffer failed\n");
		 		exit(EXIT_FAILURE);
		 	}
	 	}
	 }

      return *buffer;
 }

 int endOfLine( char * buffer )
 {
 	int i;
 	for(i=0; buffer[i]!='\0'; i++)
 	{
 		if(buffer[i]=='\n')
 		{
 			buffer[i]='\0';
 			return 1; 	
 		}
 	}
 	
 	return 0; 
 }
