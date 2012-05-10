/* THIs IS JUST A STARTER FILE - we started to write in in class together
   Tim Hoffman

   This code was borrowed and modified as need with permission from it's original author
   Mark Stelhik ( http:///www.cs.cmu.edu/~mjs ).  You can find Mark's original presentation of 
   this content in the links to his S-01 15111,  and F-01 15113 courses on his home page.
*/

import java.io.*; // io package contains the FileReader and Stream Tokenizer classes

public class Graph
{
	private final int NO_EDGE = -1; // all real edges are positive
	private int g[][];                       // will point to a 2D array to hold our graph data
	
	private int numEdges;
	public Graph( String fileName ) throws IOException  // since readFilde doesn't handle them either
	{
		readGraphFile( fileName );
	}
	
	//-------------------------------------------------readGraphFile-----------------------------------
	// opens reads and close the file, dimensions and populates the matrix as follows
	// the first number of the file is used to dimension our g[][] array
	// all the following lines contain row col weight triples
	// we read each triplet of the line and addEdge those values
	// Since we are NOT doing any try catch stuff, we must advertise (below) that we are not handling exceptions
	
	private void readGraphFile( String fileName ) throws IOException
	{
		FileReader fr = new FileReader( fileName );  // char by char access to the file
		StreamTokenizer st = new StreamTokenizer( fr ); // converts what fr gives it into tokens
		int tokenType; //  EOF, WORD, NUMBER ?
		
		int n;                      // the 1st # in the file - the n X n dimension of our graph
		int row, col, weight; // each line in the input file has this triplet
		
		tokenType=n=row=col=weight=0;  // java wants everything initalized first (yes you *can* initialize like this)
		
		// File is open and read to read - give Tokenizer the command to read a token from the file
		
		st.nextToken(); // expecting a number (our n value)
		n = (int) st.nval; // we assumed we got our number and cast it to int
		
		g = new int[n][n]; // 2D array of zeros
		numEdges=0;
		
		// you write a loop to put NO_EDGE at every non diagonal
		
		// g now contains 0s on the diagonal and NO_EDGE every elsewhere
		
		
		// start reading the file
		
		do
		{
			tokenType = st.nextToken(); // expecting row OR EOF 
			if (tokenType==StreamTokenizer.TT_EOF)  break; // jump OUT of the loop
			row =(int) st.nval;
			
			tokenType = st.nextToken(); // expecting col  	
			col =(int) st.nval;
			
			tokenType = st.nextToken(); // expecting weight  
			weight =(int) st.nval;
			
			addEdge( row, col, weight ); // punch weight value into matrix
			
			// just for testing purposes - echo the row col and weight
			System.out.println( row + " " + col + " " + weight );
			
		}  while (true); // infinite loop - only way out is via  "break" statement 
		
		// break brings you *HERE* to next line of code AFTER the loop end
		
		System.out.println("Graph File processed: " + numEdges + " stored.");
		
	} // END readGraphFile	
	
	private void addEdge( int r, int c, int w )
	{
		g[r][c] = w;
		++numEdges; // only this method adds edges so we do increment counter here only
	}
	
	// prints the matrix in table form
	// when you do Lab 2 you must reasearch and find out how to format these
	// values in 3 places right justified
	
	public void print()
	{
		for (int r=0 ; r < g.length ;++r )
		{    
			for ( int c=0 ; c<g[r].length ; ++c )
				System.out.print( g[r][c] + " ");
			System.out.println();
		}
	} // END print
	
} //EOF

