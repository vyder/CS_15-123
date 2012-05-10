/* JApplet1.java demonstrates the coordinate system allocated to an Applet
   inside an HTML window, and some simple output operations on that coord system.
   my HTLM file is JApplet1.html
*/

import javax.swing.*; // access to all the swing components widgets, dialogs etc.
import java.awt.Graphics; // access to the Graphics object (cirles, lines, graphics)

public class JApplet1 extends JApplet
{
      
	public void paint( Graphics g )  // inherited (a do-nothing version) from JApplet but we  override
	{
      String msg = new String("Hello Java!");
      int xStart,yStart;    // in pixels relative to 0,0 (the upper left origin)
      int yTall, xWide;     // in absolute pixels
      xStart = 10;
      yStart = 40;
      yTall = 50;
      xWide = 100; 
      
      g.drawString(msg,xStart,yStart );
      g.drawRect( xStart/2, yStart/2, xWide, yTall ); // first pair of args are position, 2nd pair are size
      g.drawOval( xStart/2, yStart/2, xWide, yTall ); // Note that params define "bounding rectangle"     
      
	}
}