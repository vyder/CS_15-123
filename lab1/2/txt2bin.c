#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int dec2bin( int dec );

int main (int argc, char *argv[])
{
	FILE *infile, *outfile;
	int num;
	
	if(argc != 3)		/* Checks for right number of arguments */
	{
	
		printf("Must enter two values on cmd line: input file and output file!\n");
		exit( EXIT_FAILURE );
	}
	
	infile = fopen(argv[1], "rt");
	outfile = fopen(argv[2], "wb");
	
	/* Checks if the in/out files are readable/writeable */
	if( infile==NULL )
	{
		printf("Can't open %s for input.\n", argv[1]);
		exit( EXIT_FAILURE );
	}
	
	if( outfile==NULL )
	{
		printf("Can't open %s for output.\n", argv[2]);
		exit( EXIT_FAILURE );
	}
	
	/* Loops through input file till end of file*/
	while( fscanf( infile, "%d", &num ) == 1)
	{
/*		printf("Writing number: %d\n", num); */
		fwrite( &num, sizeof(num), 1, outfile );
	}
	
	fclose( outfile );
	fclose( infile );
	
	infile = fopen( argv[2], "rb" );
	while( fscanf( infile, "%d", &num ) == 1)
	{
		printf("%d\n",num);
	}
	return EXIT_SUCCESS;
}
