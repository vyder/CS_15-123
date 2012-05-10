/* This is the tester program i'll use to grade your Lab1
   Do not hand this file in. Just hand in your Graph.java

   You must remove the throws IOException clause after main. Thus you must handle
   all exceptions in the Graph class.
*/

import java.io.*;
class Lab1
{

    public static void main( String args[] ) throws IOException // since Graph class doesn't handle them
    {
		Graph myGraph = new Graph( "graphdata.txt" );
		myGraph.print();

		System.out.println("\n-----------------------------------------");
		System.out.println("maxInDegree: " + myGraph.maxInDegree() );
		System.out.println("maxOutDegree: " + myGraph.maxOutDegree() );
		System.out.println("maxDegree: " + myGraph.maxDegree() );
		System.out.println("minInDegree: " + myGraph.minInDegree() );
		System.out.println("minOutDegree: " + myGraph.minOutDegree() );
		System.out.println("minDegree: " + myGraph.minDegree() );

		System.out.println("\n-----------------------------------------");
		System.out.println("removing edge at from node 4 to node 1 ");
		myGraph.removeEdge( 4,1 );
		System.out.println("Graph after removal of edge (4,1): ");
		myGraph.print();

		System.out.println("\n------------------------------------------");
		System.out.println("removing edge at from node 1 to node 8 ");
		myGraph.removeEdge( 1, 8 );
		System.out.println("Graph after removal of edge (1,8): ");
		myGraph.print();
    }
}
