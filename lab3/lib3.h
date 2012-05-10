#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "getline.h"


#ifndef LAB-03-LIB_H
#define LAB-03-LIB_H

void load( char * filename, char ***dictionary, int * count, int * cap );
void printDictionary(  FILE * outputStream, char **dictionary, int count );
void menu( char **dictionary, int *count, char * outfilname, int *cap );
void insert( char ***dictionary, char * wordBuffer, int * count, int *cap );
void resizeDictionary( char ***dictionary, int *capacity);
void freeAllMemory(char ***dictionary, int count);
void removeW(char **dictionary, int *count, char *rWord);
int  bSearch( char ** dictionary, int count, char *word, int *found );

#endif
