#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main( int argc, char *argv[] )
{
	int *i;
	
	printf("Mem address of i: %i\n", i);
	
	i=malloc(sizeof(int));
	
	printf("Mem address of i: %i\n", i);
	
	return EXIT_SUCCESS;
}
