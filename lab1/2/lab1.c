#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main( int argc, char *argv[] )
{
	FILE *infile;
	int sampleNum,numWaves,lastS,currentS,waveStartFlag,pd,peak,nadir;
	
	if( argc != 2)
	{
		printf("Incorrect # of arguments: Binary File name expected.\n");
		exit( EXIT_FAILURE );
	}
	
	infile = fopen(argv[1],"rb");
	
	
	/* Start processing infile */
	
	if( fread( &lastS, sizeof(lastS), 1, infile ) !=1 )
	{
		printf("No values in file!\n");
		exit( EXIT_FAILURE );
	}

	printf("Analysis of signal file: %s\n\n", argv[1]);
	printf("Sample#        Value       Detected\n");
	
	sampleNum=1;
	numWaves=0;
	waveStartFlag=0;
	peak=0;
	nadir=0;
	pd=1;
	
	while( fread( &currentS, sizeof(currentS), 1, infile ) == 1 )
	{
		if(peak<lastS)
			peak=lastS;
			
		if(nadir>lastS)
			nadir=lastS;
	
	
		if( lastS*currentS<=0 && currentS>0 )  /* New Wave detected */
		{
			if( waveStartFlag == 0 )
				waveStartFlag=1;
			else
			{
				numWaves++;
				printf("%3d:            %4d       End of wave #%d  PD: %d   Peak:%d  Nadir:%d\n",sampleNum,lastS,numWaves,pd,peak,nadir);
			}
			
			if(lastS==0)
				pd=1;
			else
				pd=0;
			
			peak=0;
			nadir=0;
		}
		
		lastS=currentS;
		sampleNum++;
		pd++;
	}
	
	printf("\n%d Full Waves detected\n", numWaves);
	
	return EXIT_SUCCESS;
}
