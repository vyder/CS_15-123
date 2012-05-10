public class ListElement
{
  private Comparable data;
  private ListElement next;

  public ListElement()
  {
    this( null, null );
  }

  public ListElement(Comparable data)
  {
    this( data, null );
  }

  public ListElement(Comparable data, ListElement next)
  {
    setData( data );
    setNext( next );
  }

  public Comparable getData()
  {
    return data;
  }

  public ListElement getNext()
  {
    return next;
  }

  public void setData(Comparable data)
  {
     this.data = data;
  }

  public void setNext(ListElement next)
  {
    this.next = next;
  }
} //EOF