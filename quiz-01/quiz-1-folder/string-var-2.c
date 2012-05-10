#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN 10
int main()
{
  char name[ MAX_LEN ];
  strcpy( name, "Timmy" );
  printf("my name is: %s\n", name );
  name[0] = 'J';
  printf("my big brother's name is: %s\n", name );
  return EXIT_SUCCESS;
}

