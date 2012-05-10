/* point2D.java
*/
public class Point2D
{
	private int x,y;


	public Point2D( int x, int y )
	{
		setX( x );
		setY( y );
	}

	// ACCESSORS
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}



	// MUTATORS
	public void setX( int x )
	{
		this.x = x;
	}
	public void setY( int y )
	{
		this.y = y;
	}



	public String toString()
	{
		return "("+x+","+y+")";
	}
}// EOF
