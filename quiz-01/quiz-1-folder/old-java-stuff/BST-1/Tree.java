public class Tree
{
	private Node root;


	// all of the following methods require recursive helper methods
	// because they require the root be passed in and recursed on.
	// the code in main can't pass in the root

	public void insert( Comparable data )
	{
		if (root == null)
			root = new Node( data );
		else
			insertHelper( root, data );

	}
	private void insertHelper( Node root, Comparable data )
	{
		int result = data.compareTo( root.getData() );

		if (result < 0) // go left
		{
			if (root.getLeft() == null)
				root.setLeft( new Node( data ) );
			else
				insertHelper( root.getLeft(), data );
		}
		if (result > 0) // go right
		{
			if (root.getRight() == null)
				root.setRight( new Node( data ) );
			else
				insertHelper( root.getRight(), data );
		}

		if (result==0) System.out.println("Ignoring insertion of duplicate data: " + data );
	} // END insertHelper



	// prints node out in sorted order
	public void inOrderPrint()
	{
		inOrderPrintHelper( root );
	}
	private void inOrderPrintHelper( Node root )
	{
		if (root==null) return;
		inOrderPrintHelper( root.getLeft() );
		System.out.println( root.getData() );
		inOrderPrintHelper( root.getRight() );
	}


	public boolean search( Comparable data )
	{
		return searchHelper( root, data );
	}

	private boolean searchHelper( Node root, Comparable data )
	{
		return false;
	}

} //EOF
