public class LinkedList
{
   private ListElement head;  // pointer to a list of elements

   public LinkedList()
   {
     head=null;
   } // END C'TOR

   public void insertAtFront( Comparable data )
   {
     head = new ListElement( data, head );
   } //END INSERT AT FRONT

   public void print()
   {
	 System.out.print( "\nThe List: ");
   	 ListElement curr = head;
   	 while (curr !=null)
   	 {
   	 	System.out.print( curr.getData() + " " );
   	 	if (curr.getNext() !=null )
   	 		System.out.print( "--> " );
   	 	else
   	 		System.out.println();

		curr = curr.getNext();   // advance to next element
   	 }
   } //END PRINT

   public String findMax( )
   {

   	if (head==null)
   	  	System.exit(0);

	Comparable maxElem = head.getData();
	ListElement tmp = head.getNext();
	while(tmp != null)
	{
		if ( tmp.getData().compareTo( maxElem ) > 0)
			maxElem = tmp.getData();
		tmp = tmp.getNext();
	}

	return maxElem.toString();

   }

}//EOF