/* SPLIT.C
	quiz #5 15-123 M09
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "getline.h"

void fatal( char * errmsg );
void printTokensArray( char **tokensArray, int tokensCnt );
void freeTokensArray( char ** tokensArray,  int tokenCnt );
char ** split(char * line, int * tokenCnt);

int main( int argc, char *argv[] )
{
	char * line;
	char **tokensArray;
	int tokenCnt=0;

	FILE * inFile = fopen( argv[1], "r" );
	if (!inFile)
	{
		fprintf(stderr,"Can't open %s for input. Program terminating!\n",argv[1] );
		exit( EXIT_FAILURE );
	}
	while (fgetline_123( &line, inFile ) )
	{
		printf("line: %s\n", line );
		tokensArray = split( line, &tokenCnt ); /* rets ptr to full array of strings */
		printTokensArray( tokensArray, tokenCnt );
		free( line );
		freeTokensArray( tokensArray, tokenCnt ); /* frees the tokens AND the array of pointers - just like lab 3 */
	}
	fclose(inFile);
	return 0;
}

void printTokensArray( char **tokensArray, int tokenCnt )
{
	int i;
	printf("tokens: ");
	for (i=0 ; i<tokenCnt ; ++i )
		printf("<%s> ", tokensArray[i] );
	printf("\n");

}

char ** split(char * line,  int * tokenCnt)
{
	char * token;
	char **tokensArray=NULL;
	*tokenCnt = 0;
	
	token = strtok( line, " \t");
	
	if(!token)
	{
		return NULL;
	}
	
	++*tokenCnt;
	tokensArray = malloc(*tokenCnt);
	strcpy(*tokensArray,token);
	
	while( token = strtok( NULL, "\t") )
	{
		++*tokenCnt;
		realloc(tokensArray, *tokenCnt);
		strcpy(*(tokensArray+*tokenCnt),token);
	}
/*	IF YOU FIND A FIRST TOKEN MaLLOC THE ARRAY TO LENGTH 1
	DEEP COPY THAT TOKEN INTO THe HEAP
	STORE ITS PTR INTO ARRAY[0]
	PARSE REMAINInG TOKENS IN THE sTRING
	WITH EACH TOKEN FOUND REALLOC THE ARRAY OF CHAR *s ONE BIGGER (dont double it)
	MAKE A DEEP COPY OF THE TOKEN AND STORE ITS PTR INTO THE ARRAY

	WHEN FINSIHED YOU WILL HAVE N TOKENS AND THE ARRAY WILL BE LENGTH N
*/
	return tokensArray;
}

void fatal( char * errmsg )
{
	fprintf( stderr, "%s\n", errmsg );
	exit( EXIT_FAILURE );
}

void freeTokensArray( char ** tokensArray, int tokenCnt )
{
	/* free each token hanging off the array of char *'s
	   then free the array of char *'s
	*/
}
