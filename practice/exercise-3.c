/* exercise-3.c

   demonstrates the following:

   - reading individual characters from stdin
   - converting the ASCII character code of a digit key to it numeric value
   - i.e. converting '5' to 5.
   - the loop models Horner's method of evaluating a polynomial

*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main( int argc, char *argv[] )
{
	int number=0;

	printf("\nYou will be repeatedly prompted for a single digt key and a RETURN.\n As soon as you enter a non digit character the loop will terminate\n\n");
	do
	{
		char digit; /* declare it in here since its not needed outside */
		printf("> ");
		fflush(stdout);
		/* read the digit into a char var */
		/* eat the RETURN From the stdin buffer */
		/* test to see if its a digit. If not break out of the loop */
		/* update the number */
		/* echo number's current value to stdout */

	} while ( 1 ); /* this is an infinte loop - we must break out */

	printf("\nFinal value of number: %d\n", number );

	return 0;

} /* END MAIN */
