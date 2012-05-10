/* Polytest.java - demonstrates Polymorphism by deriving child and grandchild
   classes, then overloading print method of child and grandchild.
*/
public class PolyTest // Polytest is out main Appp
{
	public static void main(String args[])
	{
		A a[] = { new A(), new B(), new C() };
		for (int i = 0; i < 3; i++)
		a[i].print();
	}
} // END PolyTest app


//------------------------------------------------------------------------
// We combine our class definitions in same file as main App to save space

class A 
{
	A() { }
	void print(){System.out.println("A"); }
}
class B extends A 
{
	B( ){ }
	void print(){ System.out.println("B"); }
}
class C extends B
{
	C(){}
	void print(){ System.out.println("C");}
}