class Point3D extends Point2D
{
   private int z; // we just added a new member 

   public Point3D() // def C'Tor
   {
	this( 0, 0 , 0 ); // call upon our Full C'tor to do the job
   }

   // Full C'Tor calls upon parent Full C'tor to init x,y
   // this is good code reuse - the parent knows how to init x and y 
   // never re-write tried and true logic! 
   // But we init z ourselves since parent does not know about z
   public Point3D( int x, int y, int z ) // ful C'Tor
   {
	super( x, y );
	setZ( z );
   }

   public int getZ()
   {
	return z;
   }


   public void setZ( int z )
   {
	this.z = z;
   }

   // we OVERRIDE our parent's defintion of toString since it cannot serve
   // our purpose in its form 

   // Notice in this toString code we reference x and y directly. It works 
   // because our parent declared them protected rather than private. If
   // parent had made them private, we would have to call getX and getY just
   // any other client code out in main. The keyword protected sort of 
   // keeps members "in the family"
    
   public String toString()
    {
	return "(" + x + "," + y + "," + z + ")";  
    }
}