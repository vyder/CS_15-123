/* Student class definition

*/
public class Student
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
  	return andrewID + "," + year + "," + gpa;
  }


}//EOF
