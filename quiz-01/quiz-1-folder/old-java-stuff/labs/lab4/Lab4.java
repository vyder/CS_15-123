import java.io.*;

public class Lab4
{
	private static BufferedReader kbd = new BufferedReader( new InputStreamReader( System.in ) );

	public static void main( String args[] ) throws IOException
	{
		Clock stopWatch = new Clock();
		System.out.println("\nReading: " + args[0] + " into t1");
		stopWatch.start();
		Tree t1 = new Tree( args[0] ); /* C'tor reads & inserts entire input file onto tree */
		stopWatch.stop();
		System.out.println("Done. MyTree read and built in " + stopWatch + "\n" );

		// only do prints on small files <= 100 nodes

		if ( t1.countNodes() > 100)
			System.out.println("Tree > 100 Nodes. SKIPPING PRINTS");
		else
		{
			System.out.println("\nPre Order print of t1:");
			t1.preOrderPrint();

			System.out.println("\n\nIn Order print of t1:");
			t1.inOrderPrint();

			System.out.println("\n\nPost Order print of t1:");
			t1.postOrderPrint();

			System.out.println("\n\nLevel Order print of t1:");
			t1.levelOrderPrint();
		}

		System.out.println("\n");
/*
		// Report # of nodes in Tree

		System.out.println("t1 has " + t1.countNodes() + " nodes");

		// Report # of leaves in Tree

		System.out.println("t1 has " + t1.countLeaves() + " leaves");

		// Report # of levels (depth)

		int depth = t1.depth();
		System.out.println("t1 has depth: " +  depth);

		// calculate and report the node counts at each level

		System.out.println("\nLevel Counts\n");

		int[] levelCounts = t1.calcLevelCounts();

		for (int i=0 ; i< levelCounts.length ; ++i )
			System.out.println("level " + i + ": " + levelCounts[i] );

		// NOW EXECUTE SOME METHODS THAT ARE SPECIFIC TO LAB #4

		// COPY C'Tor: - should produce a DEEP COPY of an existing tree
		// that is identical in ALL ways to the tree passed into the consturctor

		Tree t2 = new Tree( t1 );

		if (t1.isEqual( t2 ) )
			System.out.println("t1 and t2 are identical \n");
		else
			System.out.println("t1 and t2 are NOT identical\n");
/*
		if ( t2.countNodes() > 100)
			System.out.println("Tree > 100 Nodes. SKIPPING PRINTS");
		else
		{
			System.out.println("\n\nLevel Order print of t2:");
			t2.levelOrderPrint();
		}

		// Extra Credit method prettyPrint()

		if ( args[0].equals("prettyPrintInput.txt") )
		{
			t1.prettyPrint(); // both trees should
			t2.prettyPrint(); // print out identical
		}

		do // MENU LOOP
		{
			System.out.print("Enter 'S'earch, 'I'nsert, 'R'emove, 'P'rint, 'Q'uit: ");
			String response = kbd.readLine();
			if (response.equalsIgnoreCase("S"))
				doSearch(t1);
			else if (response.equalsIgnoreCase("I"))
				doInsert( t1 );
			else if (response.equalsIgnoreCase("R"))
				doInsert( t1 );
			else if (response.equalsIgnoreCase("Q"))
				doQuit();
			else if (response.equalsIgnoreCase("P"))
			{
				doPrint( t1 );
			}
			else
				System.out.println("Unrecognized command. Try again.");
		} while (true);
*/
	} //END main

	public static void doSearch( Tree t ) throws IOException
	{
		System.out.print("Enter word to search for: " );
		String target = kbd.readLine();
		if (t.search( target ))
			System.out.println(target + " found");
		else
			System.out.println(target + " NOT found");
	}

	public static void doInsert( Tree t ) throws IOException
	{

		System.out.println("Enter word to insert: " );
		String target = kbd.readLine();
		t.insert( target );
	}

	public static void doRemove( Tree t ) throws IOException
	{

		System.out.println("Enter word to insert: " );
		String target = kbd.readLine();
		t.remove( target );
	}

	public static void doPrint( Tree t )
	{
		//t.levelOrderPrint();
	}

	public static void doQuit()
	{
		System.exit(0);
	}


} //EOF


