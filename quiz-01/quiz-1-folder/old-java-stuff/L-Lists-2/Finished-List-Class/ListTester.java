public class ListTester
{
	public static void main( String args[] )
	{
		LinkedList myList = new LinkedList();

		myList.insertAtFront("foo");
		myList.insertAtFront("bar");
		myList.insertAtFront("baz");
		myList.insertAtFront("bag");
		myList.insertAtFront("gorp");

	System.out.println("myList: " +  myList ); // invokes toString
	} // END MAIN
} // EOF