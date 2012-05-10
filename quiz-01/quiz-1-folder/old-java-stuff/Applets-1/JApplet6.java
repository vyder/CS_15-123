/*  JApplet6.java demonstrates the following Swing concepts:
- the JScrollBar control
- the Applet's contentPane
- inerface AdjustmentListener and it's method adjustmentValueChanged
- an inner class to implement the AdjustmentListener interface
- registering  widgets ( <i>add()</i> ) with their associated event handler class

 */

import java.awt.*;  // basic graphics: draw Color etc.
import java.awt.event.*; // events
import javax.swing.*; // the Swing widgets: JButton etc.

public class JApplet6 extends JApplet implements AdjustmentListener
{
    // declare refs to these components up here so we don't have to pass them around
    private JScrollBar slider;  // a standard Java control
    private int sliderValue;   // to save the current value of the sliderValue
    private Container content; // ref to the JApplet's content pane

    public void init()
    {
        content = getContentPane();
        content.setBackground(Color.white);  // set ContentPane's background to white
        content.setLayout( new FlowLayout() );

        int initVal, extent, minVal, maxVal;
        initVal=50 ; extent=0; minVal=0; maxVal=100;

        // slider produced values from 0 to 100 in increments of 1, jump of 0 defaults to 10
        slider = new JScrollBar( JScrollBar.HORIZONTAL, initVal, extent, minVal, maxVal );
        content.add( slider );

        slider.addAdjustmentListener( this );

    }

    public void adjustmentValueChanged( AdjustmentEvent ae )
    {
       sliderValue = slider.getValue();
       showStatus("Current value is " + sliderValue );
    }

}