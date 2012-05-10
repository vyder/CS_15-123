/* msalley.c

	prints out 1 thru 5 on a single line
    then 5 downto 1 on the next line
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main( int argc, char *argv[] )
{
    int i;
    for (i=1 ; i<=5 ; ++i)
    	printf("%d ",i);
    printf("\n");


    for (j=5 ; j>0 ; --j)
    	printf("%d ",j);
    printf("\n");

    return 0;

}