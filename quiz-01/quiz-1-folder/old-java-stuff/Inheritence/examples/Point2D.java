/*	Point2D class defintion file
	Describes a point in the 2D place

	data members of this class are protected instead of private. Doing so
	allows children of this class (inheritence) to directly access these
	data members.
*/


class Point2D 
{
    protected int x;   
    protected int y;

    // DEFAULT C'TOR
    public Point2D( )
    {
	this( 0, 0 ); // calls the 2 arg version of this class' C'tor
    }

    // FULL C'TOR
    public Point2D( int x, int y ) // notice we only call the setters in the FULL C'Tor
    {
	setX( x );
        setY( y );
    }
    

    // SETX MNETHOD IS THE ONLY PEICE OF CADE THAT SHOULD EVER MODIFY X
    public void setX( int x )
    {
        this.x = x;
    }

    // SETY METHOD IS THE ONLY PEICE OF CADE THAT SHOULD EVER MODIFY Y
    public void setY( int y )
    {
        this.y = y;
    }

    public String toString()
    {
	return "(" + x + "," + y + ")";  
    }


}