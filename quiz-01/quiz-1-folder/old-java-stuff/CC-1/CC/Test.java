//Name      :
//Course    : 15-
//Instructor:
//Section   :


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

			// grab a line from the file and store in a String

			// instance a STringTokenizer on that String. the semicolon char ( ";" )is the separator

			// grab the first token off the line and store in an Object


			// now load the rest of the words on this line into a List
			// declare an ArrayList

			// loop thru the iterator calling .add() with the .next() token parsed until the line is exhausted

			// sort the List of words lexically (see our 2nd Exercise - reuse that code

			// now .put() the key and its associated List of words into the HashMap

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


		// declare an ArrayList to hold the keys

		// declare an iterator on the ArrayList to
		Iterator it = map.keySet().iterator(); // finds all the keys from the HashMap and gives us an iterator to access them

		// use iterator to access them - order of visitation is not guaranteed - thats why we store into a List for sorting

		// loop thru the set of keys using the iterator. Once you have the key use it to get the associated List

		// now sort the ArrayList  of keys

		// now traverse our sorted ArrayList  printing each key on its own line - followed by it's associated list (which is also sorted)

		System.out.println("Map (sorted alphabetically by Category and by Exemplars)");
		for(int k=0 ; k<keyList.size() ; ++k)
		{

			// print the k'th key via a call to get() on the sorted ArrayList

			// use the key tio retriev the associated value
			// this value is an ArrayList so you must declere and ArrayList and cast the assignment

			// use a loop to print associated ArrayList of emeplar words
		}

		/* PHASE III:
		Read a line of category words from a file and build a sentence (store it in a List) by selecting one random
		exemplar word for each category word that is read. All words are separated by one semi-colon character.
		For example, the input file sentence.txt contains the following line:

		  name;verb;article;adj;do

		It indicates a name is to be followed by a verb, which is followed by an article, etc.
		*/

		allLines = ExamIO.readFile("\nEnter Category/Word file name");
		String line = (String)allLines.next(); // grab a line (IN THIS CASE THE ONLY LINE)  from the file

		// decalre a tokenizer to parse the token in this line - ';' separator again
		// decalre an ArrayList for holding the category words

		// loop to add all the tokens to the ArrayList of category words

		// loop to use each category word to retrieve a random exemplar word and print those examplars out
		// into an examplar sentence


	} //END MAIN

	// HELPER FUNCTION WE WROTE

	private static void sortList( ArrayList list )
	{

	}
} //EOF