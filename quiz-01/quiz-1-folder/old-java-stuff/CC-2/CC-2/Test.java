
import introExam.ExamIO;
import java.lang.Comparable;
import java.util.*;


public class Test
{
	private static String randomWord(List l)
	{
		return (String)l.get((int)(l.size()*Math.random()));
	}

	public static void main(String[] args)
	{
		Iterator allLines = ExamIO.readFile("Enter PAC/members file name");

		// Declare a hashmap to store the names of the PACs
		HashMap pacs = new HashMap();

		while (allLines.hasNext() )
		{
			// PHASE I: We want to store the forst token of the line into a String to represent the PAC name
			// the rest pof the tolken are the memnbers names. We store those names in a HashSet instead of
			// an ArrayList cause we want to do SET operations on the elements (interesection)

			// grab a line for the file iterator and wrap it in a String Tokenizer seperator is ";"


			// parse 1st token is the pac name


			// remainder of line is membership - declare HashSet to store them


			// loop thru the rest of the tokens and .add() them to the Set


			// .put() the key value pair into the HashMap

		}

		// Create an ArayList of the keys in sorted order


		// declare an iterator on the keySet from the Hashmap


		// declare an ArrayList to store the PAC names (keys)


		// iterate thru the keySet and .add each key into the ArrayList


		// sort the ArrayList of keys using code we alreay wrote



		// use those sorted keys to get the associated membership sets
		// print PAC name followed by its members' names

		// loop here



		allLines = ExamIO.readFile("Enter intersection file name");
		while (allLines.hasNext() )
		{
			// grab a line from File iterator and parse the 2 totkens - they are 2 pac names



			// 2 pac names per line - store each in a string



			// use the 2 pac names to .get() their member lists from the HashMap of pacs
			// cast the .get() as HashMap and use it as C'Tor for new HasSet


			// user retain all on other set passing other in as arg. This retains intercetion
			// print that set (use an iterator on that set)

			System.out.println("PAC members of the pac1 and pac2");


	} //END MAIN


	private static void sortList( ArrayList list )
	{
		Object listElements[] = list.toArray();
		Arrays.sort( listElements );
		list.clear();
		for (int i=0 ; i<listElements.length ; ++i)
			list.add( listElements[i] );
	}
} //EOF