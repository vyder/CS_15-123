#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	int x,y;
	
	printf("Enter a value for x: ");
	fflush( stdout );
	if( scanf("%d %d", &x, &y) == 2)
		printf("You entered %d for x and %d for y\n",x,y);
	
	return EXIT_SUCCESS;
}
