/* djurado.c

prints out 1 thru N on a single line

*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main( int argc, char *argv[] )
{
	int n;
	char *s;
	println("Enter a small positive int: ");
	fgetline_123( &s, stdin);
	n = atoi(s);

    int i,j;
    for (i=1 ; i<=n ; ++i)
    	printf("%d ",i);
    printf("\n");

    return 0;

}