// STARTER FILE FOR IN CLASS EXERCISE (ArrayList)

import java.util.*;
import java.io.*;

public class Exercise2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));

		// ArrayList is a class that implements the List interface

		ArrayList words = new ArrayList(); // creates an empty ArrayList

		while (true)
		{
			System.out.print("\nEnter a word: " );
			String word = kbd.readLine();

			if (word.equals("quit"))
				break;

			// YOUR CODE BELOW: ( 1 line of code ) to .add() the word into the ArrayList

			words.add( word );
		}

		// Write a loop to retrieve and print all the words in original order from the list.
		// use .get(i) to retrieve the ith word

		System.out.println( "Printing ArrayList via calls to .get(i)" );

		for (int i=0 ; i<words.size() ; ++i )
		{
			System.out.println( (String) words.get(i) );
		}
		System.out.println();

		// Write a loop to retrieve and print all the words in original order from the list.
		// use an Iterator

		Iterator iter = words.iterator();
		System.out.println( "Printing ArrayList via an iterator with calls to .next()" );

		while ( iter.hasNext() )
		{
			System.out.println( (String) iter.next() );
		}
		System.out.println();


		// Exercise II: Sort the elements in the ArrayList.  There is no mechanism to directly sort
		// the contents of an ArrayList in place. No sort method() built in or inherited to use :=(.
		// Thus we must copy the elements into a plain Java array, then sort that array, clear the
		// ListArray then copy the sorted elements back into the ArrayList.

		// Write a private static helper method for this (see sortList below)

		sortArrayList( words );

		// Now print the list again using either an iterator OR calls to .get(i)

		System.out.println( "Printing *SORTED* ArrayList via calls to .get(i)" );

		for (int i=0 ; i<words.size() ; ++i )
		{
			System.out.println( (String) words.get(i) );
		}
		System.out.println();
	}// END MAIN

	private static void sortArrayList( ArrayList words )
	{
		// Use the .toArray() method of the ArrayList class to store a copy of the elements in a
		// standard Java array of Object

		Object elements[] = words.toArray();

		// Use the sort method from the Array class (that's CAPITOL 'A' Array ) to sort the array

		Arrays.sort( elements ); // assumes element type implements Comparable!

		// .clear() the list

		words.clear();

		// Now copy the sorted array elements from the simple array to the ListArray
		// be sure to preserve order - append at back

		for (int i=0 ; i<elements.length ; ++i)
			words.add( elements[i] );
	} // END SORTARRAYLIST
}//END CLASS

