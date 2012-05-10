/*
	Graph.java

	myName:
	myAndrewID:
*/


import java.io.*; // io package contains the FileReader and Stream Tokenizer classes
public class Graph
{
	private Edge g[];     // every element g[i] is the head of a LinkedList of Edges
	private int numEdges;
	private int numNodes;

	//-------------------------------------------------------------------------------------
	public Graph( String fileName )
	{
		readGraphFile( fileName );
	}

	//-------------------------------------------------------------------------------------

	private void readGraphFile( String fileName )
	{
		// open the grahp file and read in the number at the top
		// dimension g to be that long

	} // END readGraphFile


	//-------------------------------------------------------------------------------------
	private void addEdge( int src, int dest, int weight ) // Insert on FRONT of list
	{
		// go to g[src] and insert a new Edge onto the FRONT of the list


	}

	//-------------------------------------------------------------------------------------
	private boolean hasEdge( int src, int dest )
	{
		// go to g[src] and look for (find) an edge whose dest field == dest

	}

	//-------------------------------------------------------------------------------------
	// 			           P R I V A T E   N O D E   P R O P E R T Y   M E T H O D S
	//-------------------------------------------------------------------------------------
	private int inDegree( int node )
	{
		// search every Edge in every list
		// count how many Edges have node as the dest field
		//
		//

	}

	//-------------------------------------------------------------------------------------
	private int outDegree( int node )
	{
		// just count the # of edges hanging off g[node]
	}

	//-------------------------------------------------------------------------------------

	private int degree( int node )
	{

	}

	//-------------------------------------------------------------------------------------
	// 			           P U B L I C   G R A P H   P R O P E R T Y   M E T H O D S
	//-------------------------------------------------------------------------------------
	public int minInDegree()
	{
	}

	//-------------------------------------------------------------------------------------
	public int minOutDegree()
	{
	}

	//-------------------------------------------------------------------------------------
	public int minDegree()
	{
	}

	//-------------------------------------------------------------------------------------
	public int maxInDegree()
	{
	}

	//-------------------------------------------------------------------------------------
	public int maxOutDegree()
	{
	}
	//-------------------------------------------------------------------------------------
	public int maxDegree()
	{
	}
	//-------------------------------------------------------------------------------------
	public void print()
	{
		// print out each list hanging from g[i] on single line
		// see solution output
	} // END print


} //EOF


