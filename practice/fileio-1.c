/* fileio-1.c  demonstrates:

	argc, argv
	atoi(), exit()
	printf(), fprintf(), fscanf()
	fopen(), fclose()
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main( int argc, char *argv[] )
{
 	FILE *infile, *outfile;
 	int x,i,n;

	if (argc < 3 )
	{
		printf("must enter a small positive int followed by name for output file on cmd line\n");
		exit( EXIT_FAILURE );
	}

	n = atoi( argv[1] ); /* do a "man" on atoi(). Its sorta like parseInt() in Java */
	if (n<=0)
	{
		printf("must enter a SMALL POSITIVE INT  followed by name for output file on cmd line\n");
		exit( EXIT_FAILURE );
	}

 	outfile = fopen(argv[2], "wt" ); /* "wt" means we are writing text to the file */
 	if (outfile==NULL) /* then the open must have failed */
 	{
		printf("Can't open %s for output.\n", argv[2] );
 		exit( EXIT_FAILURE );
	}

	/* READY TO WRITE A SEQUENCE Of INTS TO THE OUTPUT TEXT FILE */
	printf("\nWriting to file %s\n", argv[2] );
	for (i=1 ; i<=n ; ++i )
	{
		printf("...wrote %d\n",i);
		fprintf( outfile, "%d\n", i );
	}
	fclose( outfile );

	/*RE-OPEN THAT FILE AS INPUT AND READ THEM BACK IN AND ECHO TO STDOUT */

 	infile = fopen(argv[2], "rt" ); /* "rt" means we are reading the text file */
 	if (infile==NULL) /* we really don't expect this to happen considering we just wrote it - but we always test */
 	{
		printf("Can't open %s for input.\n", argv[2] );
 		exit( EXIT_FAILURE );
	}

	printf("\nNow reading from file %s\n", argv[2] );
	for (i=1 ; i<=n ; ++i )
	{
		fscanf( infile, "%d", &x );
		printf("...read %d\n",x);
	}
	fclose( infile );

    return 0;
}
