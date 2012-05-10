import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class EtchSketch extends JApplet
	implements MouseListener, MouseMotionListener
{
	String msg = "";
	int mouseX=0,mouseY=0;
	int oldX=0, oldY=0;

	public void init()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// Handles mouse pressed
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		showStatus("Mouse Pressed at: " +
			mouseX + "," + mouseY );
		//repaint();
	}

	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		// drawPoint( x,y );
		Graphics g = getGraphics();
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		showStatus("Mouse Dragged at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		showStatus("Mouse Moved at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		showStatus("Mouse clicked at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		showStatus("Mouse released at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		showStatus("Mouse exited at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		showStatus("Mouse Entered at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
}//EOF