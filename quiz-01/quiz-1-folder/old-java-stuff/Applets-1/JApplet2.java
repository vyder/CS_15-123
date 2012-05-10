/* JApplet2.java demonstrates the coordinate system allocated to an Applet
   inside an HTML window via the drawLine method and demonstrates the use of
   the init method override and the writing of new methods.
   my HTLM file is JApplet2.html
*/

import javax.swing.*; // access to all the swing components widgets, dialogs etc.
import java.awt.Graphics; // access to the Graphics object (cirles, lines, graphics)

public class JApplet2 extends JApplet
{
	// vars or objects declared here are "global" to the whole JApplet2 class

	private int startX, stopX, startY, stopY, numLines;

    /* When your Applet loads into the Browser. The Browser imediately declares
	  an object of type JApplet2 (your Applet defintion) then it does the following:
	  1) call init()
	  2) call paint()
	  if your Applet gets hidden or minimized the browser calls the stop() method. 
	  if the Applet is then uncovered or unminimized repaint is called
	  If your HTML page gets closed the broswer calls dispose. 
	*/

   // inherited from JApplet - we override
	public void init() // called 1st by browser
	{
		startX = 100;
		stopX = 300;
		startY = 75;
		stopY = 350;
		numLines=10;

	}

	// paint is called right after init. It gets re-called every time the Applet region
	// needs redrawn due to an overlapping window covering a portion etc.
   
   // inherited from JApplet - we override
   public void paint( Graphics g ) // // called 2nd by browser
	{                               // 
		g.drawString( "Calling method DrawSomeLines(..)", 25, 25);
		
		// these lines calls takes 2 pairs of coords.
		// the first is the  start point:  100,25
		// the 2nd pair is the end point: 172, 25
	
	    // drawSomeLines is a method I just made up  in this applet!

		drawSomeLines( g, startX, startY, stopX, stopY, numLines );

	} // END paint
	
   // totally new "free" method  
   public void drawSomeLines( Graphics g, int x1, int y1, int x2, int y2, int numL )
	{
		// drawLines takes 2 pairs of coords.
		// the first is the  start point: x,y
		// the 2nd pair is the end point: x,y

		for (int i= 0 ; i < numL; ++i )
			g.drawLine( x1 + i*10, y1 + i*(-10), x2 + i*(-20), y2 + i*10 );
	} //END drawSomeLines
	
} //EOF