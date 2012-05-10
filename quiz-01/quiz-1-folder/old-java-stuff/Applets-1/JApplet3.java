/* JApplet3.java demonstrates the browser's automatic repaint of the Applet 
   when the page is refreshed of if some other object overwrites any part
   of the Applet.
   my HTLM file is JApplet3.html
*/

import javax.swing.*; // access to all the swing components widgets, dialogs etc.
import java.awt.Graphics; // access to the Graphics object (cirles, lines, graphics)
import java.util.Random;
public class JApplet3 extends JApplet
{
	private Random r = new Random();
	public void paint( Graphics g )  // inherited (a do-nothing version) from JApplet but we  override
	{
		String msg = JOptionPane.showInputDialog("Enter a message");
		g.drawString(msg, r.nextInt(100)+50, r.nextInt(250)+50 );
	}
}