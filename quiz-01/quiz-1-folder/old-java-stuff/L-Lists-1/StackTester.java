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
	} //END main
} //EOF