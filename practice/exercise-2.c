#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
	int inches,feet;
	
	printf("Enter your height in inches (whole number): ");
	fflush(stdout);
	scanf( "%d", &inches);
	feet=inches/12;
	inches=inches%12;
	
	printf("Your height is %d feet and %d inches\n", feet, inches);
	
	return 1;
}
