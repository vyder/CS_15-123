/* Priority Queue class

*/

public class PQ
{
  private ListElement queue; // pointer to the first element in the list


  public boolean isEmpty()
  {
    return queue==null;
  }

  public void makeEmpty()
  {
	queue=null;
  }

  // THIS IS PSUEDO CODE - IT DOES NOT COMPILE!!!
  // YOU MUST CHANGE THE > AND < OPERATORS TO COMPARETO

  public void enQueue( Comparable data )
  {
	// 2 cases where insertAtFront is needed

	if ( isEmpty() || data.compareTo(queue.getData()) < 0   ) // change < to compareTo()
	{
		queue= new ListElement( data, queue);
		return;
	}

	// NOW TRAVERSE LIST FOR INSERTION POINT

	ListElement curr = queue;

//	while ( curr.getNext() != null &&  data.compareTo(queue.getData()) > 0 ) // change > to compareTo()
		//curr = curr.getNext();

	curr.setNext( new ListElement( data, curr.getNext() ) );
  }

  // throws Exception if there is no front element to pop
  public Comparable deQueue() throws Exception
  {
	if ( isEmpty() )
		throw new Exception( "DQ attempted on an empty Q");

	ListElement tmp = queue; // save a ptr to front elem
	queue=queue.getNext(); // remove from Q
	return tmp.getData();  // return the data of the old top
  }

  // throws Exception if there is no top element
  public Comparable front() throws Exception
  {
	if ( isEmpty() )
		throw new Exception( "front attempted on an empty queue");

	return queue.getData();
  }


  public void print( String msg )
  {
	System.out.print(msg + " ");
	for (ListElement curr = queue ; curr!=null ; curr=curr.getNext() )
		System.out.print( curr.getData() + " " );
	System.out.println();
  }

}// EOF
