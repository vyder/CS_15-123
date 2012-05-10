/* ListElement class definition

	Defines its data fiels as type Object
	This allows users of ListElement to pass ANY
	class type into a ListElement's Constructor

*/

public class ListElement
{
  private Comparable data;
  private ListElement next;

  public ListElement( Comparable data, ListElement next)
  {
     setData( data);
     setNext( next );
  }
  public void setData( Comparable data )
  {
     this.data = data; // this.data is the member field, data is the incoming arg
  }
  public Comparable getData()
  {
     return data;
  }
  public void setNext( ListElement next )
  {
     this.next = next; // this.next is the member field, next is the incoming
  }
  public ListElement getNext()
  {
     return next;
  }

}//EOF