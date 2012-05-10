
/*
   This is the specification of the |getline| library.

   Last modified 24 January 2006 by Arthur O'Dwyer.
   Public domain.
*/


#ifndef H_GETLINE
 #define H_GETLINE

#include <stdio.h>  /* for the |FILE| type */

/*
   Call as "rc = getline_123(&line);"
   These two functions trim off the trailing newline (and any other
   trailing whitespace) for you, so if the user types <space>-H-E-L-
   L-O-<space>-<enter>, all you see is <space>-H-E-L-L-O.
*/
char *getline_123(char **p);
char *fgetline_123(char **p, FILE *stream);

/*
   Same as above, but these two don't trim newlines or whitespace.
   If the user types <space>-H-E-L-L-O-<space>-<enter>, the resulting
   string will contain <space>-H-E-L-L-O-<space>-<newline>.
*/
char *getline_notrim(char **p);
char *fgetline_notrim(char **p, FILE *stream);

/*
   This function is provided for your convenience.
   "getline_123(&p)" behaves as if "trim_123" were called on the
   resulting string before returning from the function.
*/
char *trim_123(char *line);

#endif
