// Futile attempt to swap ints. Can't work! Java has no pass by reference and no reference operator
public class Futile
{
   public static void main(String args[])
   {
   	int x,y;
   	x=5;
   	y=10;
   		
	System.out.println("Before swap x: " + x + "  y: " + y );
   	swap( x, y );
   	System.out.println("After swap  x: " + x + "  y: " + y );
   }
   
   // this swap method must be static because main is static. You may not call a non static method
   // from a static context.
   
   public static void swap( int a, int b )
   {
   	int temp = a;
   	a = b;
   	b = temp;
   }
} //EOF