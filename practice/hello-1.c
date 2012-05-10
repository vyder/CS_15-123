/* hello-1.c
   Illustrates: printf, fflush, stdin, stdout
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main( )
{
    int x,y;

	printf("Hello World: Enter two small positive numbers for x and y: ");
	fflush(stdout); /* needed because output streams are buffered */

	if( (scanf("%d %d", &x, &y)) < 2 )
		printf("One or more bad numbers\n");
	
	printf("\nYou entered %d for x and %d for y\n", x,y);

    return 0;

}
