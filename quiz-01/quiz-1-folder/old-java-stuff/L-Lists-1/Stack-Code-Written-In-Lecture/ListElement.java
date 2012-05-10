// This ListElement type is used by Stack, Queue and Priority Queue

public class ListElement
{
  private Comparable data;
  private ListElement next;

  public ListElement( Comparable data, ListElement next)
  {
     setData( data );
     setNext( next );
  }

  public void setData(  Comparable data )
  {
     this.data = data; // this.data is the member field, data is the incoming
  }

  public Comparable getData()
  {
     return data;
  }

  public void setNext(  ListElement next )
  {
     this.next = next; // this.next is the member field, next is the incoming
  }

  public ListElement getNext()
  {
     return next;
  }
}//EOF