public class StackTester
{
	public static void main( String args[] ) throws Exception
	{
		Stack myStack = new Stack();

		myStack.push("foo");
		myStack.push("bar");
		myStack.push("baz");
		myStack.push("bag");
		myStack.push("gorp");
		myStack.push("blarp");

		myStack.print("myStack: ");

		for (int i=0 ; i<7 ;++i )
		{
		  System.out.println( myStack.top() ); // prints top elem
		  System.out.println( myStack.pop() ); // prints AND removes top elem
		}
	} //END main
} //EOF