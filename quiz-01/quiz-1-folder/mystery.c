#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int mystery()
{
  char *data[] = { "I", "will", "not", "miss", "this", "one" };
  char words[6][4];
  int i;
  for (i=5; i>=0 ; --i)
    strcpy( words[i], data[i]);

  for (i=0; i<6 ; ++i)
    printf("%s\n", words[i]);

  return 0;
}

int main()
{
  mystery();
  return 0;
}
