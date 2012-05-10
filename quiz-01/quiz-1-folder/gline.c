/*getline.c
  Illustrates use of non ansi getline function
  Don't use -ansi in your compilation command if you use this function
*/

#include  <stdio.h>     /* for printf definition       */
#include  <stdlib.h>    /* EXIT_SUCCESS */
#include  <string.h>

/* #define _GNU_SOURCE  tells compiler you are using the GNU (glibc) library */
#define INITIAL_BUF_CAP    5
int main()
{
  int i;
  char *buffer=malloc(INITIAL_BUF_CAP);
  size_t buflen = 0;
  printf("Enter your first name ");
  fflush(stdout);
  getline( &buffer,  &buflen, stdin );
  printf("getline malloc'd %d chars for the buffer\n", buflen );
  printf("Your name is: %s\n", buffer );
  printf("\n          char   ascii\n");
  for (i=0 ; i<buflen; ++i)
    printf("buffer[%d]: %3c   %3d\n",i, buffer[i],buffer[i]);

  return EXIT_SUCCESS;
}
