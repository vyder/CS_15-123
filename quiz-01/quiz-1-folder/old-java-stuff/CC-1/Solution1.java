// STARTER FILE FOR IN CLASS EXERCISE (HashMap)

import java.util.*;
import java.io.*;

public class Solution1
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));

		// HashMap is a class that implements the Map interface

		HashMap dictionary = new HashMap(); // creates an empty HashMap

		// put() a <key,value> pair into the Map

		String key = "foo";
		String value ="meta-syntactic variable used in programming examples";
		dictionary.put( key, value ); // word is the key, definition is the mapped value

		// get()  the value by supplying the key

		System.out.println("The defintion of foo: " +  dictionary.get(key) );

		// Write a loop to repeatedly prompt user for (key,value) pairs until user types "quit"
		// put each pair into the Map as follows:
		//

		while (true)
		{
			System.out.print("\nEnter a word: " );
			String word = kbd.readLine();

			if (word.equals("quit"))
				break;

			System.out.print( "Enter its defintion: " );
			String definition = kbd.readLine();

			dictionary.put( word, definition );
		}

		// Write a loop to retrieve and print all the keys and values from the Map
		// each line of output should be:  definition of <word> is: <definition>
		// We do this by first grabbing te set of keys via a call to .keySet() on the HashMap
		// Then we need a way to retrieve each individual key in that keySet.

		// For this we introduce the Set and Iterator. A call to dictionary.keySet() produces a
		// reference to the set of keys in the map. On that set we add a .iterator() call to get
		// an iterator.  Once the iterator is initialize we can grab the next element in the set via
		// a call to .next(). We can query the iterator to see if we have traversed the entire set
		// yet via a call to boolean method hasNext().

		// An Tokenizer is similar in nature to an Iterator. It visits all the elements in a set
		// one after another and keeps track of when all the elements have been visited.

		Iterator iter = dictionary.keySet().iterator();

		while (iter.hasNext())
		{
			key = (String) iter.next(); // stored as Object so we must cast back to the original type inserted
			value = (String) dictionary.get( key ); // stored as Object so we must cast back to the original type inserted
			System.out.println("the defintion of " + key + ": " + value );
		}


	}
}