#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main ( int argc, char *argv[] )
{
       FILE *infile, *outfile;

       short int x, y, sh, temp;
       unsigned char ch;

       short s1, s2, temp2;

       /* checking if the input values were entered*/
       if (argc < 3)
       {
               printf("must enter names of source text file and output binary file");
               exit( EXIT_FAILURE );
       }

       /* opening input text file*/
       infile  = fopen(argv[1], "rd" );
       if (NULL==infile)
       {
               printf("Can't open %s for input. \n", argv[1] );
               exit( EXIT_FAILURE );
       }

       /* opening output binary file*/
       outfile = fopen(argv[2], "wb" );
       if (NULL==outfile)
       {
               printf("Can't open %s for output. \n", argv[2] );
               exit( EXIT_FAILURE );
       }


       /*reading from text file and writing to output binary file*/
       while ( fscanf(infile, "%hi", &x) == 1)
       {
               if(fscanf(infile, "%hi", &y) == 1)
               {
                       sh = x;
                       sh = sh << 4;
                       temp = y;
                       temp = temp >> 8;
                       sh += temp;
                       fwrite( &sh, sizeof(sh), 1, outfile);
                       y = y << 8;
                       y = y >> 8;
                       ch =  y;
                       fwrite( &ch, sizeof(ch), 1, outfile);
               }
               else
                       fwrite( &x, sizeof(x), 1, outfile);
       }


       fclose( infile );
       fclose( outfile );

       /* opening binary file as input file */
       infile = fopen(argv[2], "rb" );
       if (NULL==infile)
       {
               printf("Can't open %s for input. \n", argv[2] );
               exit( EXIT_FAILURE );
       }

       /* displaying file data */
       while ( fread( &sh, sizeof(sh), 1, infile) == 1)
       {
               if(fread( &ch, sizeof(ch), 1, infile) == 1)
               {
                       temp2 = sh;
                       temp2 = temp2 >> 4;
                       s1 = temp2;
                       sh = sh << 12;
                       sh = sh >> 4;
                       sh += ch;
                       s2 =  sh;
                       if(s1 < 0 && s2 < 0)
                               s1 += 1;
                       printf("%hd\n",s1);
                       printf("%hd\n",s2);
               }
               else
               {
                       printf("%hd\n", sh);
               }
       }
       fclose( infile );

       return 0;
}
