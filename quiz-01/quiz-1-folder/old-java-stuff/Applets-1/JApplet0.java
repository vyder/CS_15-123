/* JApplet0.java demonstrates the coordinate system allocated to an Applet
   inside an HTML window via text output
   HTLM file is JApplet0.html
*/

import javax.swing.*; // access to all the swing components widgets, dialogs etc.
import java.awt.Graphics; // access to the Graphics object (cirles, lines, graphics)
public class JApplet0 extends JApplet
{    
	public void paint( Graphics g )  // override inherited paint method
	{
	      g.drawString("Saying 'Hello' at x=100  y=200",100,200 );
	}
}