/* This is the tester program i'll use to grade your Lab1
   Do not hand this file in. Just hand in your Graph.java

   You must remove the throws IOException clause after main. Thus you must handle
   all exceptions in the Graph class
*/

import java.io.*;
class Lab1
{

    public static void main( String args[] ) throws IOException // since Graph class doesn't handle them
    {
		Graph myGraph = new Graph( "graphdata.txt" );
		myGraph.print();

		System.out.println("maxInDegree: " + myGraph.maxInDegree() );
		System.out.println("maxOutDegree: " + myGraph.maxOutDegree() );
		System.out.println("maxDegree: " + myGraph.maxDegree() );
		System.out.println("minInDegree: " + myGraph.minInDegree() );
		System.out.println("minOutDegree: " + myGraph.minOutDegree() );
		System.out.println("minDegree: " + myGraph.minDegree() );

		System.out.println("removing edge at from node 3 to node 5 ");
		myGraph.removeEdge( 3, 5 );
		System.out.println("Graph after removal of edge (3,5): ");
		myGraph.print();

		System.out.println("removing edge at from node 1 to node 6 ");
		myGraph.removeEdge( 1, 6 );
		System.out.println("Graph after removal of edge (1,6): ");
		myGraph.print();

    }
}
