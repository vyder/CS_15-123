public class LinkedList
{
	private ListElement head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place

	public void insertAtFront(Object data)
	{
		head = new ListElement(data,head);
	}

	// we use toString as our print

	public String toString()
	{
		String res = new String();

		for (ListElement curr = head; curr != null; curr = curr.getNext())
		{
			res += curr.getData().toString();
			if (curr.getNext() != null)
				res += " -->; ";
		}
		res += "\n";

		return res;
	}
} //EOF