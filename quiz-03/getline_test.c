
/*
   This program demonstrates proper use of the |fgetline| function,
   defined in "getline.c" and "getline.h". Compile it with
   "gcc -O2 -W -Wall -ansi -pedantic".

   Last modified 6 December 2005 by Arthur O'Dwyer.
   Public domain.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "getline.h"


static FILE *get_inputfile(int argc, char **argv);


int main(int argc, char **argv)
{
    char *line, *rc;
    FILE *fp = get_inputfile(argc, argv);
    int done = 0;

    while (!done) {
        rc = fgetline_123(&line, fp);

        /*
           First, we check for errors. In a real program, we wouldn't
           generally need to single out each possible cause of an error,
           but the following code shows how you would single out a
           cause if you needed to.
        */
        if (rc == NULL) {
            /* Something went wrong! */
            if (line == NULL) {
                puts("getline ran out of memory immediately!");
            }
            else if (ferror(fp)) {
                printf("getline had an I/O error after %lu characters!\n",
                    (unsigned long)strlen(line));
                done = 1;
            }
            else if (feof(fp)) {
                printf("getline reached EOF after %lu characters!\n",
                    (unsigned long)strlen(line));
                done = 1;
            }
            else if (strlen(line) < (size_t)-2) {
                /*
                   Note: If |strlen(line)| is |(size_t)-2|, then
                   the buffer is actually |(size_t)-1| bytes long.
                */
                printf("getline ran out of memory after %lu characters!\n",
                    (unsigned long)strlen(line));
            }
            else {
                puts("getline found a line longer than (size_t)-1 characters!");
            }
        }
        else {
            /* |line| is definitely non-null */
            if (line[0] != '\0' && feof(fp)) {
                printf("getline reached EOF after %lu characters!\n",
                    (unsigned long)strlen(line));
                done = 1;
            }
        }

        /*
           Note that |line| may be non-null even though |rc| be null.
           This happens if we read a partial line and then hit an I/O
           error or end-of-file.
        */
        if (line != NULL) {
            rc = strchr(line, '\n');
            if (rc != NULL) {
                puts("A full line was read.");
                *rc = '\0';
            }
            else puts("A partial line was read.");
            if (strlen(line) > 200)
            {
                printf("The line was: >%.70s<...>%s<\n",
                    line, strchr(line, '\0')-70);
            }
            else printf("The line was: >%s<\n", line);
        }

        /* Freeing a null pointer is harmless; no special case is needed. */
        free(line);
    }

    /* All open files are closed upon program termination. */
    return 0;
}


static FILE *get_inputfile(int argc, char **argv)
{
    if (argc < 2) {
        return stdin;
    }
    else if (argc == 2) {
        if (strcmp(argv[1], "-") == 0)
          return stdin;
        else {
            FILE *fp = fopen(argv[1], "r");
            if (fp != NULL)
              return fp;
            puts("Usage: getline_test [inputfile]");
            printf("I couldn't open input file '%s'.\n", argv[1]);
            exit(EXIT_FAILURE);
        }
    }

    puts("Usage: getline_test [inputfile]");
    puts("Zero or one arguments, please!");
    exit(EXIT_FAILURE);
}

