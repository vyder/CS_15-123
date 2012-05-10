/*  JApplet4.java demonstrates the following Swing concetps:
- the JButton widget
- the Applet's contentPane
- FlowLayout
- inerface ActionListener and it's method actionPerformed
- an inner class to implement the ActionListener interface
- registering  widgets ( <i>add()</i> ) with their associated event handler class
- distinguishing which button on the content pane was clicked
- modiying the background color of the contentPane
 */
import java.awt.*;  // basic graphics: draw Color etc.
import java.awt.event.*; // events
import javax.swing.*; // the Swing widgets: JButton etc.
public class JApplet4 extends JApplet implements ActionListener
{
    // declare JButtons at this level so we don't have to pass them around.
    // we need access to these names in multiple scopes

    private JButton jbRed, jbGreen, jbYellow, jbBlue; // need access in init() and in handler
    private Container content;   // need access in init() and in handler

    public void init()
    {
        // you can't add widgets directly onto a JApplet - you add them to the ContentPane
        content = getContentPane();

        content.setBackground(Color.white);  // set ContentPane's background to white
        content.setLayout(new FlowLayout()); // widgets bubble to top, centered

        jbRed = new JButton("Red");  // button is created with caption "Red"
        jbGreen = new JButton("Green"); // button with caption "Green"
        jbYellow = new JButton("Yellow");
        jbBlue = new JButton("Blue");

        jbRed.setBackground(Color.red); // button face is all red
        jbGreen.setBackground(Color.green); // button face all green
        jbYellow.setBackground(Color.yellow);
        jbBlue.setBackground(Color.blue);

        // order of adding is important, bubble to top, left to right, centered
        content.add(jbRed);
        content.add(jbGreen);
        content.add(jbYellow);
        content.add(jbBlue);

        // finally add each button to the listener so that when you click
        // on it, that click wil be recognized

        jbRed.addActionListener(this);
        jbGreen.addActionListener(this);
        jbBlue.addActionListener(this);
        jbYellow.addActionListener(this);

    }// END init


    public void actionPerformed( ActionEvent e ) // actionPerformed is the interface method we MUST override
    {
            // unfortunately you CAN'T CASE out test for buttons - use IFs
       Object whichButton = e.getSource();
       if (whichButton == jbRed)
            content.setBackground(Color.red); // whole content pane same color as button face
       else if (whichButton == jbGreen)
            content.setBackground(Color.green); // whole content pane same color as button face
       else if (whichButton == jbBlue)
            content.setBackground(Color.blue); // whole content pane same color as button face
       else if (whichButton == jbYellow)
           content.setBackground(Color.yellow); // whole content pane same color as button face
       else
       {
                // we omitted a test for one of our buttons. programmer error
                // handle as you will
       }
    } // END actionPerformed
} //EOF