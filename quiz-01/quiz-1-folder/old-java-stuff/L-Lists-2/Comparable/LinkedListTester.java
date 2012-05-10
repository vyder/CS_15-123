public class LinkedListTester
{
  public static void main(String args[] )
  {
	LinkedList list = new LinkedList();

	list.insertAtFront( new Student("tlh", 1991, 2.2) );
	list.insertAtFront( new Student("tmick", 206, 4.0) );
	list.insertAtFront( new Student("mtd", 2005, 3.79)  );
	list.insertAtFront( new Student("swati", 2006, 3.85) );

	list.print();

	System.out.println("Class valdectorian is: " + list.findMax() );
  }

}//EOF
