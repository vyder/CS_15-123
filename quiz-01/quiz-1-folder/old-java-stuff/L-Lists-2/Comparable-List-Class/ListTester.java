import java.io.*;
import java.util.*;

public class ListTester
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader inFile = new BufferedReader( new FileReader( args[0] ) );
		String line;

		String id;
		int year,ssn,dob;
		double gpa;

		LinkedList myList = new LinkedList();

		while ( (line=inFile.readLine()) != null )
		{
			StringTokenizer st = new StringTokenizer( line );
			id = st.nextToken();
			year = Integer.parseInt( st.nextToken() );
			gpa = Double.parseDouble( st.nextToken() );
			ssn = Integer.parseInt( st.nextToken() );
			dob = Integer.parseInt( st.nextToken() );

			myList.insertAtFront( new Student(id,year,gpa,ssn,dob) );
		}

		System.out.println("myList: " +  myList ); // invokes toString
	} // END MAIN
} // EOF