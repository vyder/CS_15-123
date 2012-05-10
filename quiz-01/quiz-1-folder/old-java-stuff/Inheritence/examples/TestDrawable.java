/* TestDrawable.java
   define an inteface and implement that interface in a class
*/

interface Drawable 
{
	public final static int BLUE = 1, RED = 2;
	void setColor(int c);
	void setPosition(double x, double y);
	void draw();
} //END interface Drawable


// by implementing Drawable we are required to define the code bodies for 
// setColor, setPosition, and draw inside this class

class DrawableCircle extends Circle implements Drawable 
{
	private int color;
	private double xpos, ypos;
	public DrawableCircle(int radius)   
	{
		super(radius); // just called our Parent (Circle's) C'Tor
		System.out.println("Just constructed Drawable Circle");
	}
	public void setColor(int c)  
	{
		color = c;
		System.out.println("set Color");
	}
	
	public void setPosition(double x, double y) 
	{
		xpos = x; ypos = y;
		System.out.println("Set Position");
	}
	
	public void draw()   
	{
		System.out.println("Draw");
	}

} // END DrawableCircle class

// ================ App with Main method ==================

public class TestDrawable 
{
  public static void main(String args[])   
  {
	DrawableCircle c = new DrawableCircle(5);
	System.out.println(c.area());
	System.out.println(c.perimeter());
	c.setColor(Drawable.BLUE);
	c.setPosition(1.5, 2.5);
	c.draw();
  }
}


