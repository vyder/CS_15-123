public class Student implements Comparable
{
	private String andrewID;
	private int year;           // 1=frosh, 2=soph,3=jr,4=sr,5=grad,6=phD
	private double gpa;         // 0.0 - 4.0
	private int ssn;            // standard 9 digit mark of the beast
	private int dob;            // YYYYMMDD format is self sorting

	public Student()
	{
		this("N/A", 0, 0.0, 0, 0 );
	}

	public Student( String andrewID, int year, double gpa, int ssn, int dob )
	{
		setAndrewID( andrewID );
		setYear( year );
		setGpa( gpa );
		setSsn( ssn );
		setDob( dob );
	}

	public void setAndrewID( String andrewID )
	{
		this.andrewID = andrewID;
	}


	public void setYear( int year )
	{
		this.year = year;
	}

	public void setGpa( double gpa )
	{
		this.gpa = gpa;
	}

	public void setSsn( int ssn )
	{
		this.ssn = ssn;
	}

	public void setDob( int dob  )
	{
		this.dob = dob;
	}

	public String toString()
	{
		return "id: " + andrewID + " yr: " + year + " gpa: " + gpa + " ssn: " + ssn + " dob: " + dob;
	}

	/* As the class deginer we make the arbitrary decision on how ordering is done. For this example,
		we will order students by their gpa.

	   The return values are:

	  -1  this.gpa  <  other.gpa
	   0  this.gpa ==  other.gpa
	   1  this.gpa  >  other.gpa
	*/
	public int compareTo( Object other )
	{
		if (this.gpa == ((Student)other).gpa )  // we can access other's privys cause he's one of us
			return 0;
		if (this.gpa < ((Student)other).gpa )
			return -1;

		return 0;
	}

} // EOF