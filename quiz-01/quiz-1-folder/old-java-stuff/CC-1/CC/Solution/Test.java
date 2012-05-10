// SOLUTION

//Exam specific class
import introExam.ExamIO;

//Java Interfaces
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

//Java Classes
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;


public class Test
{
	private static String randomWord(List l)
	{
		return (String)l.get((int)(l.size()*Math.random()));
	}

	public static void main(String[] args)
	{
		Iterator allLines = ExamIO.readFile("Enter Category/Word file name");
		Map map = new HashMap(); // use default C'Tor

		/* PHASE I: Load the input file data into the HashMap

		First, read a file of words one line at a time, building a Map whose key
		is the first word on the line and whose value is a List of all subsequent
		words on that line: from each category word to a List of all its exemplar words.
		All words are separated by one semi-colon character. For example,
		the input file substitutions.txt contains the following lines:
  			name;Fred;Bob;Mary
			verb;throws;eats;chases;breaks
			article;a;the;this
			adj;big;red;small;blue
  			do;wagon;ball;hot-dog

		Here, for example, the category word verb is associated with the List of exemplar words throws, eats, chases, and breaks.
		*/

		while (allLines.hasNext() ) // the Iterator is given to us. We just call next() to get the next line from the file
		{

			String line = (String)allLines.next(); // grab a line from the file
			StringTokenizer strtok = new StringTokenizer( line, ";" ); // prepare to tokenize splitting on ';'
			Object key = strtok.nextToken(); // the fisrt token of like is the key

			// key is the first string on the line - now load the rest of the words on this line into a List

			ArrayList val = new ArrayList(); // this List will hold the all but first word on a line
			while (strtok.hasMoreTokens())
				val.add( strtok.nextToken() );

			// sort the List of words lexically
			sortList( val );

			// now store the key and its associated List of words into the HashMa

			map.put( key, val );
		}

		/* PHASE II: Retrieve the keys from the HashMap and print the keys and associated words in sorted order one per line.


		Print a sorted version of this Map: the category words must be printed in alphabetical order, one per line,
		each followed -on the same line- by its List of exemplar words, which must also printed in alphabetical order.
		For the input file shown above, the program should print the following lines:

  		Map (sorted alphabetically by Category and by Exemplars)
	    adj can be replaced by [big, blue, red, small]
	    article can be replaced by [a, the, this]
	    do can be replaced by [ball, hot-dog, wagon]
	    name can be replaced by [Bob, Fred, Mary]
	    verb can be replaced by [breaks, chases, eats, throws]
		*/

		ArrayList keyList = new ArrayList(); // this List will store the keywords so we can sort them
		Iterator it = map.keySet().iterator(); // finds all the keys from the HashMap and gives us an iterator to access them

		// use iterator to access them - order of visitation is not guaranteed - thats why we store into a List for sorting

		while (it.hasNext())
		{
			Object key = it.next();
			keyList.add( key );
		}
		sortList( keyList ); // sort our keys

		// now traverse our sorted keylist printing each key on its own line - followed by it's associated list (which is also sorted)

		System.out.println("Map (sorted alphabetically by Category and by Exemplars)");
		for(int k=0 ; k<keyList.size() ; ++k)
		{
			System.out.print( keyList.get(k) + " can be replaced by [" );
			ArrayList val = (ArrayList) map.get( keyList.get(k) );
			for (int v=0 ; v<val.size() ; ++v )
				if (v<val.size()-1)
					System.out.print(val.get(v) + ", " );
				else
					System.out.println(val.get(v) + "]" );
		}

		/* PHASE III:
		Read a line of category words from a file and build a sentence (store it in a List) by selecting one random
		exemplar word for each category word that is read. All words are separated by one semi-colon character.
		For example, the input file sentence.txt contains the following line:

		  name;verb;article;adj;do

		It indicates a name is to be followed by a verb, which is followed by an article, etc.
		*/

		allLines = ExamIO.readFile("\nEnter Category/Word file name");
		ArrayList categoryWords = new ArrayList(); // this List will hold sentence template words
		String line = (String)allLines.next(); // grab a line (IN THIS CASE THE ONLY LINE)  from the file

		StringTokenizer strtok = new StringTokenizer( line, ";" ); // prepare to tokenize splitting on ';'
		while (strtok.hasMoreTokens())
			categoryWords.add( strtok.nextToken() );

		for (int i=0 ; i < categoryWords.size() ; ++i )
		{
			String cWord = (String) categoryWords.get(i); // must cast back to specific type put in
			ArrayList eWords = (ArrayList) map.get( cWord );
			//int randIndex = (int) (Math.random() * eWords.size());
			System.out.print( randomWord( eWords ) + " ");
		}
		System.out.println();

	} //END MAIN

	// HELPER FUNCTION WE WROTE

	private static void sortList( ArrayList list )
	{
		// copy from ArrayList to array of Object
		Object listElements[] = list.toArray();
		Arrays.sort( listElements ); // assumes element type implements Comparable!
		list.clear();

		// put back into list (now in sorted order)
		for (int i=0 ; i<listElements.length ; ++i)
			list.add( listElements[i] );
	}
} //EOF