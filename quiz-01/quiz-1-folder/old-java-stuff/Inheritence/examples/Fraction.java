/* Fraction class ilustrating the folllowing OOP concepts:
	- private data
	- default constructor
	- overloaded constructors
	- use of keyword  'this'
	- toString method
*/


public class Fraction  // if we leave off public - it defaults to package.
{
	// private data
	private int numer, denom; 
   
	// default constructor which calls 1 arg overload via   this(..)
	public Fraction()
	{
		this( 0 ); // produces 0/1		
	}

	// 1 arg overloaded constructor which calls 2 arg constructor via   this(..)
	public Fraction( int numer )
	{
		this( numer, 1 ); // produces numer/1
	}

	// 2 arg constructor uses keyword this to distinguish data members from incoming arg names
	public Fraction( int numer, int denom )
	{
		this.numer = numer;
		this.denom = denom;
	}

	public void setNumer( int numer )
	{
		// check for bad incoming value first
		this.numer = numer;  
	}

	public void setDenom( int denom )
	{
		// check for bad incoming value first 
		this.denom = denom;  
	}

	public int getNumer()
	{
		return numer;
	}

	public int getDenom()
	{
		return denom;
	}


	// "polite" class designers write a toString method in their class definition
	// so that users of the class can print out a dump of the object state by just
	// printing the object variable itself
	public String toString()  // called implicitly by the compiler
	{
		return numer + "/" + denom;
	}
	
}