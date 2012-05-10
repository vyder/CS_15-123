public class PQTester
{
	public static void main( String args[] ) throws Exception
	{
		PQ myPQ = new PQ();

		myPQ.enQueue("zebra");
		myPQ.enQueue("bar");
		myPQ.enQueue("monkey");
		myPQ.enQueue("dogs");
		myPQ.enQueue("cats");
		myPQ.enQueue("aardvark");

		myPQ.print("myPQ: ");

		for (int i=0 ; i<7 ;++i )
		{
		  System.out.println( myPQ.front() ); // prints front elem
		  System.out.println( myPQ.deQueue() ); // prints AND removes front elem
		}
	} //END main
} //EOF