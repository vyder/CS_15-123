/* Stack Class class implements the following operations
Default Constructor : inits the data member stack to null
push : add an element to the front of the list
pop : remove the front (top) element
top : return (but not remove) front data value
isEmpty : boolean tells if stack is empty
makeEmpty : set queue=null - let garbage collector deal with orphaned elements

*/

public class Stack
{
  private ListElement stack;  // pointer to the first element in the list

  // C'Tor
  public Stack()
  {

  }

  public boolean isEmpty()
  {
    return true; // replace with real code
  }

  public void makeEmpty()
  {
      // your code here
  }

  public void push( Comparable data )
  {
	// your code here (hint: insert at front just like in linked list land)

  }

  // throws Exception if there is no top element to pop
  public Comparable pop() throws Exception
  {
	return null; // replace with real code
  }

  // throws Exception if there is no top element
  public Comparable top() throws Exception
  {
	return null; // replace with real code
  }


  public void print( String msg )
  {
	System.out.print(msg + " ");
	for (ListElement curr = stack ; curr!=null ; curr=curr.getNext() )
		System.out.print( curr.getData() + " " );
	System.out.println();
  }

}// EOF
