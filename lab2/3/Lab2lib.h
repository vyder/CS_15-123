/* Lab2lib.h */

#ifndef Lab2lib_H

  #include <stdlib.h>
  #include <stdio.h>
  #include <string.h>

  #define Lab2lib_H
  #define MAX_WORDS   50000     /* ROWS */  
  #define MAX_WORDLEN 50   /* COLUMNS */ 

  void loadDictionary( char * filename, char dictionary[][MAX_WORDLEN], int *count );  
  void removeNewln( char wordBuffer[MAX_WORDLEN] );
  void insert( char dictionary[][MAX_WORDLEN], char * wordBuffer, int * count );
  void menu( char dictionary[][MAX_WORDLEN], int *count, char *outfilname);
  void printDictionary( FILE * outputStream, char dictionary[][MAX_WORDLEN], int count );
  int searchWord( char dictionary[][MAX_WORDLEN], char *  word, int count );
  void removeWord( char dictionary[][MAX_WORDLEN], char * word, int * count, int index );

#endif
