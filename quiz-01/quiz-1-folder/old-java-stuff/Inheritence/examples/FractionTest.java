// A trivial Java application that declares an object of the Fraction type (class)
// If the Fraction.class is not compiled yet, compiling this file will cause 
// Fraction.java to be compiled as needed, assuming Fraction.java is sitting in the 
// same directory as this file.

public class FractionTest
{
   public static void main(String args[])
   {
	Fraction f1 = new Fraction();  // test of default C'Tor
	Fraction f2 = new Fraction( 22,7 ); // test of 1 arg C'Tor
	Fraction f3 = new Fraction( 3 ); // test of 2 arg C'Tor
		
	f1.setNumer( 5 );
	f3.setDenom( 17);
	
	// this print statement does not explicitly call toString() BUT the compiler implicitly
	// calls it for you when you try to print the "whole object" in a print statement.
	// if you don't have a toSting in your class definition, then you just get 
	// the address of the object printed :(

      System.out.println("f1 = " + f1 + "\n" + "f2 = " + f2 + '\n' + "f3 = " + f3 ); // test of toString()
   }
}