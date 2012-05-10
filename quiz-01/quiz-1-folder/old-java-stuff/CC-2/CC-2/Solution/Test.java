
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

		Map pacs = new HashMap();

		while (allLines.hasNext() )
		{

			String line = (String)allLines.next();
			StringTokenizer strtok = new StringTokenizer( line, ";" );

			// 1st token is the group name
			String pac = strtok.nextToken();

			// remainder of line is users
			Set members = new HashSet();

			while (strtok.hasMoreTokens())
				members.add( strtok.nextToken() );

			pacs.put( pac, members );
		}

		// Print the map by keys in sorted order

		ArrayList pacList = new ArrayList();
		Iterator it = pacs.keySet().iterator();
		while (it.hasNext())
		{
			Object pac = it.next();
			pacList.add( pac );
		}
		sortList( pacList );


		for(int g=0 ; g<pacList.size() ; ++g)
		{
			Object pac = pacList.get(g);
			System.out.print( pac + " PAC members: \n\t" );
			Set members = (HashSet) pacs.get(pac);
			it = members.iterator();
			while (it.hasNext())
				System.out.print(it.next() + " " );
			System.out.println();
		}


		allLines = ExamIO.readFile("Enter intersection file name");
		while (allLines.hasNext() )
		{
			String line = (String)allLines.next();
			StringTokenizer strtok = new StringTokenizer( line, ";" );

			// 2 group names per line
			String pac1 = strtok.nextToken();
			String pac2 = strtok.nextToken();


			HashSet members1 = new HashSet( (HashSet) pacs.get(pac1) );
			HashSet members2 = new HashSet( (HashSet) pacs.get(pac2) );

			System.out.println("PAC members of " + pac1 + " and " + pac2 );
			members1.retainAll( members2 ); // now only the common elements remain in members1
			Iterator it1 = members1.iterator();
			while (it1.hasNext())
				System.out.println( it1.next() );
			System.out.println();
		}

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