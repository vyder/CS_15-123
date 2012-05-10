#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
  char *words[] = { "real", "programmers", "use", "emacs" };
  int i;

  for (i=0 ; i<4 ; ++i )
    printf( "%s ", words[i] );
  printf("\n");

  words[3][0]='v';

  return EXIT_SUCCESS;
}

