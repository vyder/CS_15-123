public class LinkedList
{
	private ListElement head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	//---------------------------------------------------------

	public void insertAtFront(Comparable data)
	{
		head = new ListElement(data,head);
	}

	public void insertAtBack(Comparable data)
	{
		if (head == null)
			head = new ListElement(data);
		else
		{
			ListElement curr = head;
			while (curr.getNext() != null)
				curr = curr.getNext();
			curr.setNext(new ListElement(data));
		}
	}

	public Comparable search(Comparable key)
	{
		for (ListElement curr = head; curr != null; curr = curr.getNext())
		{
			if (curr.getData().equals(key))
				return curr.getData();
		}
		return null;
	}

	public boolean remove(Comparable key)
	{
		if (head == null)// empty list
			return false;

		if (head.getData().equals(key))// ListElement to be deleted is first ListElement
		{
			head = head.getNext();
			return true;
		}

		for (ListElement curr = head; curr.getNext() != null; curr = curr.getNext())
		{
			if (curr.getNext().getData().equals(key))
			{
				curr.setNext(curr.getNext().getNext());
				return true;
			}
		}

		return false;
	}

	public boolean isEmpty()
	{
		return head==null;
	}


	public String toString()
	{String res = new String();

		for (ListElement curr = head; curr != null; curr = curr.getNext())
		{
			res += curr.getData().toString();
			if (curr.getNext() != null)
				res += " --> ";
		}
		res += "\n";

		return res;
	}
}