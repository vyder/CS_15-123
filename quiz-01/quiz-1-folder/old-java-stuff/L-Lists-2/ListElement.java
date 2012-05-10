public class ListElement
{
  private Object data;
  private ListElement next;

  public ListElement()
  {
    this( null, null );
  }

  public ListElement(Object data)
  {
    this( data, null );
  }

  public ListElement(Object data, ListElement next)
  {
    setData( data );
    setNext( next );
  }

  public Object getData()
  {
    return data;
  }

  public ListElement getNext()
  {
    return next;
  }

  public void setData(Object data)
  {
     this.data = data;
  }

  public void setNext(ListElement next)
  {
    this.next = next;
  }
} //EOF