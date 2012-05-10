// Use this main program to test your Graph class solution
// There is no need to hand it in. Just hand in your Graph.java file
// and your readme.txt file

// ** YOUR NAME HERE  **
// DONT MODIFY THIs FILe OTHEr THAN ADDING YOUr NAME AND SECTIoN

import java.io.*;
class Lab1
{   
   public static void main( String args[] ) 
   {
      if (args.length < 1) 
      {
         System.out.println("usage: must enter filename on command line.");
         System.exit(0);
      }
      System.out.println("\nInstructor Solution for F01-15200 Lab#1\nReport any bugs/questions to Tim Hoffman ASAP");
    
      Graph myGraph = new Graph( args[0] );
      myGraph.print(); // each value 4 places right justified		
      System.out.println();
      System.out.println("maxOutDegree: " + myGraph.maxOutDegree() );
      System.out.println("minOutDegree: " + myGraph.minOutDegree() );
      System.out.println("maxInDegree: " + myGraph.maxInDegree() );
      System.out.println("minInDegree: " + myGraph.minInDegree() );
      System.out.println("maxDegree: " + myGraph.maxDegree() );
      System.out.println("minDegree: " + myGraph.minDegree() );
      
   } // END main
   
} // EOF

