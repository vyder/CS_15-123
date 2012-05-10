#include  <stdio.h>     /* for printf definition       */
#include  <stdlib.h>    /* EXIT_SUCCESS */
#include  <string.h>


#define MAX_CHARS       5
#define BUF_CAP         MAX_CHARS + 1
#define QUOTE(x)        #x
#define VAL2STR(x)      QUOTE(x)

int main() 
{
  int i;
  char buffer[BUF_CAP]={'\0'}; /* first char is null char */
  printf("Enter your first name ");
  fflush(stdout);
  fscanf(stdin, "%"VAL2STR(MAX_CHARS)"s", buffer); 
  printf("Your name is: %s\n", buffer ); 
  printf("\n          char   ascii\n");
  for (i=0 ; i<BUF_CAP ; ++i)
    printf("buffer[%d]: %3c   %3d\n",i, buffer[i],buffer[i]);

  return EXIT_SUCCESS;
}
