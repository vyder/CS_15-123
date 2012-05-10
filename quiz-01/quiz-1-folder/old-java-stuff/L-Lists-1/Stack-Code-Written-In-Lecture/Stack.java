/* Stack Class class implements the following operations
Default Constructor : inits the data member stack to null
push : add an element to the front of the list
pop : remove the front (top) element
top : return (but not remove) front data value
isEmpty : boolean tells if stack is empty
makeEmpty : set stack- let garbage collector deal with orphaned elements

*/

public class Stack
{
  private ListElement stack;  // pointer to the first element in the list


  public boolean isEmpty()
  {
    return stack==null;
  }

  public void makeEmpty()
  {
	stack=null;
  }

  public void push( Comparable data )
  {
	stack = new ListElement( data, stack );

  }

  // throws Exception if there is no top element to pop
  public Comparable pop() throws Exception
  {
	if ( isEmpty() )
		throw new Exception( "pop attempted on an empty stack" );

	ListElement tmp = stack; // save a ptr to top
	stack=stack.getNext(); // remove from list
	return tmp.getData();  // return the data of the old top
  }

  // throws Exception if there is no top element
  public Comparable top() throws Exception
  {
	if ( isEmpty() )
		throw new Exception( "top attempted on an empty stack" );

	return stack.getData();
  }


  public void print( String msg )
  {
	System.out.print(msg + " ");
	for (ListElement curr = stack ; curr!=null ; curr=curr.getNext() )
		System.out.print( curr.getData() + " " );
	System.out.println();
  }

}// EOF
