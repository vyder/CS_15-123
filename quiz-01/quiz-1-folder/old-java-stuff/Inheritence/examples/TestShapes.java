/* TestShapes.java defines an abstract Shape class then defines Circle and Square
   classes based on Shape. 
*/

public class TestShapes
{
	public static void main(String args[])
	{
		Circle c = new Circle( 3.0 );
		System.out.println("Circle C has area: " + c.area() );
		System.out.println("Circle C has perimeter: " + c.perimeter() );
		Square s = new Square( 10.0 );
		System.out.println("Square S has area: " + s.area() );
		System.out.println("Square S has perimeter: " + s.perimeter() );
	} // END main
} // END TestShapes

// ----------------------------------------------------------------------------------
// We define our Shape, Circle and Square classes in the same file as our main App
// ----------------------------------------------------------------------------------


// ..................................................................................
abstract class Shape
{
		public abstract double area();
		public abstract double perimeter();
}

//...................................................................................
class Circle extends Shape  // OK - we derive from Shape 
{
	double radius;  // we added this data member to our abstract base defintion - OK
	Circle( double radius )
	{
		this.radius = radius;
	}
	public double area() //  REQURIED  override of abstract parent's area
	{
		return( Math.PI * radius*radius );  
	} 
	public double perimeter()  // REQUIRED override of  abstract parent's perimeter
	{
		return( 2.0 * Math.PI * radius );
	} 
}
	
// ..................................................................................
class Square extends Shape  // OK - we derive from Shape 
{
	private double side;  // we added this data member to our abstract base defintion - OK
	Square( double side )
	{
		this.side = side;
	}
	public double area() //  REQURIED  override of abstract parent's area
	{
		return( 2.0 * side );  
	} 
	public double perimeter()  // REQUIRED override of  abstract parent's perimeter
	{
		return( 4.0 * side );
	} 
}