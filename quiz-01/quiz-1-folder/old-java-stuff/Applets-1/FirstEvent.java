import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class FirstEvent extends Applet implements AdjustmentListener
{
	private Scrollbar slider;  // a standard Java control
	private int sliderValue;   // to save the current value of the sliderValue
	public void init()
	{
		slider = new Scrollbar( Scrollbar.HORIZONTAL, 0,1,0,100 );
		add( slider );
		slider.addAdjustmentListener( this );		
	}

	public void adjustmentValueChanged( AdjustmentEvent ae )
	{
		sliderValue = slider.getValue();
	  	repaint();		
	}
	
	
	public void paint(Graphics g)
	{
		g.drawString("Current value is " + sliderValue, 100, 100 );
	}
} // END APPLET


