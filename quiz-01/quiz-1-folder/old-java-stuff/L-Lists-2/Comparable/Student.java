/* Student class definition

	becasue Student implements the Comparable interface. The Student
	class MUST have a method whose signature is:

		public int compareTo( Object other )

	The writer of the compareTo() method may however compute the return value
	based on whatever oredring criteria she chooses.

*/
public class Student implements Comparable // we MUST write:  public int compareTo( Object other )
{
  private String andrewID;
  private int year; // YYYY: expected year of grad.
  private double gpa;

  // FULL C'TOR
  public Student( String andrewID, int year, double gpa )
  {
     setAndrewID( andrewID );
     setYear( year );
     setGpa( gpa );
  }

  // MUTATORS: (a.k.a "setters")
  public void setAndrewID(String andrewID)
  {
     this.andrewID= andrewID;
  }
  public void setYear( int year )
  {
     this.year= year;
  }
  public void setGpa( double gpa )
  {
     this.gpa = gpa;
  }

  // ACCESSORS: (a.k.a "getters")

  public String getAndrewID()
  {
     return andrewID;
  }
  public int getYear()
  {
     return year;
  }
  public double getGpa()
  {
     return gpa;
  }

  public String toString()
  {
  	return andrewID + " " + year + " " + gpa;
  }

  /* This method is required to be in this class because this class implements
  the Comparable interface.  It is up to us however to decide what makes one student
  less that, equal or greater than the other.

  The return value is:
  	negative number if this < incoming
  	0 if this == incoming
  	positive if this > incoming
  */

  public int compareTo( Object other )
  {
	  double diff = ((Student)this).gpa - ((Student)other).gpa;


	  if ( diff <  0.0 ) return -1;
	  if ( diff == 0.0 ) return  0;
	  return 1;
  }
}//EOF
