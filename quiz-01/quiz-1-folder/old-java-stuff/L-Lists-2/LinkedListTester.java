public class LinkedListTester
{
  public static void main(String args[] )
  {
	LinkedList list = new LinkedList();

	list.insertAtFront( new Point2D(5, 8) );
	list.insertAtFront( new Fraction(22, 7)  );
	list.insertAtFront( new String("Objects are the ancestor of all class types!") );

	list.print();
  }
}//EOF
