/* StaticTest.java defines a class with a static data member which gets incremented
   every time an object of the class is constructed.
  
   *Note: we get to the static variable in foo class via the classname foo
		NOT via a ref var of the class
*/

public class StaticTest
{
	public static void main(String args[] )
	{
		System.out.println("numObjects before any created: " + foo.numObjects );

		foo f1 = new foo();
		foo f2 = new foo();
		foo f3 = new foo();
		foo f4 = new foo();
	
		System.out.println("numObjects after some objects created: " + foo.numObjects );
	} // END main
}

// we put our class defintion inside our app file again

class foo
{
	public static int numObjects;
  
	foo()
	{
		++numObjects; // increment static object counter
		System.out.println("Just constructed foo object " + foo.numObjects );
	}
}