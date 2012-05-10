public class Node
{
	Comparable data;
	Node left,right;

	public Node( Comparable data )
	{
		this.data = data;
	}

	public Node getLeft()
	{
		return left;
	}

	public Node getRight()
	{
		return right;
	}


	public void setRight( Node r)
	{
		right = r;
	}

	public void setLeft( Node l)
	{
		left = l;
	}

	public Comparable getData()
	{
		return data;
	}

	public void setData( Comparable data)
	{
		this.data = data;
	}


} // EOF