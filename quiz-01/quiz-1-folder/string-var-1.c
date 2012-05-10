#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
  char name[] = { 'T', 'i', 'm', 'm', 'y', '\0' };
  printf("my name is: %s\n", name );
  name[0] = 'J';
  printf("my big brother's name is: %s\n", name );
  return EXIT_SUCCESS;
}

