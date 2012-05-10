/*  JApplet5.java demonstrates the following Swing concepts:
- the JButton, JTextField, JPanel
- the Applet's contentPane
- GridLayout
- inerface ActionListener and it's method actionPerformed
- an inner class to implement the ActionListener interface
- registering  widgets ( <i>add()</i> ) with their associated event handler class
- distinguishing which button on the content pane was clicked
- modifying the contents of a JTextField via it's setText() and getText() methods
 */

import java.awt.*;  // basic graphics: draw Color etc.
import java.awt.event.*; // events
import javax.swing.*; // the Swing widgets: JButton etc.

public class JApplet5 extends JApplet implements ActionListener
{
    // declare refs to these components up here so we don't have to pass them around
    private JTextField jtxtFirst, jtxtSecond, jtxtAnswer;
    private JButton jbPlus, jbMinus, jbMulti, jbDivide, jbRemainder, jbClear;
    private JPanel jp1, jp2, jp3, jp4;
    private Container content; // ref to the JApplet's content pane

    public void init()
    {
        content = getContentPane(); // ref to this JApplet's content pane

        /* assign a GridLayout (NOT FlowLayout anymore) to our content pane.
        Entire JApplet face divied into 4 row, 5 cols, 5 pixels space between cells
        Analogous to HTML table except no padding between cells and outer border
         */

        content.setBackground(Color.white);  // set ContentPane's background to white
        content.setLayout( new GridLayout(4, 1, 5, 5) );

        jbPlus = new JButton("+");
        jbMinus = new JButton("-");
        jbMulti = new JButton("*");
        jbDivide = new JButton("/");
        jbRemainder = new JButton("%");
        jbClear = new JButton("Clear");

        jtxtFirst = new JTextField();
        jtxtSecond = new JTextField();
        jtxtAnswer = new JTextField();
        jtxtAnswer.setEditable(false); // user CANNOT edit this field but GUI code CAN via setText()

        // Panels allow for our widgets to be grouped

        jp1 = new JPanel(new GridLayout(1,2,5,5));
        jp2 = new JPanel(new GridLayout(1,1,5,5));
        jp3 = new JPanel(new GridLayout(1,3,5,5));
        jp4 = new JPanel(new GridLayout(1,3,5,5));

        // Add each JButton or JTextField to a grouping Panel, NOT directly to content pane

        jp1.add(jtxtFirst); jp1.add(jtxtSecond);
        jp2.add(jtxtAnswer);
        jp3.add(jbPlus); jp3.add(jbMinus); jp3.add(jbMulti);
        jp4.add(jbDivide); jp4.add(jbRemainder); jp4.add(jbClear);

        content.add(jp1);
        content.add(jp2);
        content.add(jp3);
        content.add(jp4);

        // all our widgets are initialized and grouped on Panels. The stage is set
        // Now declare a ref to our event handler and register those widgets with their listener


        jbPlus.addActionListener(this);
        jbMinus.addActionListener(this);
        jbMulti.addActionListener(this);
        jbDivide.addActionListener(this);
        jbRemainder.addActionListener(this);
        jbClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
      Object whichButton = e.getSource(); // ref to JButton that got clicked

      double dblFirst, dblSecond, dblAnswer=0.0;
      dblFirst	= new Double(jtxtFirst.getText()).doubleValue();
      dblSecond = new Double(jtxtSecond.getText()).doubleValue();

      if (whichButton == jbPlus)
      {
         dblAnswer = dblFirst + dblSecond;
      }
      else if (whichButton == jbMinus)
      {
         dblAnswer = dblFirst - dblSecond;
      }
      else if (whichButton == jbMulti)
      {
         dblAnswer = dblFirst * dblSecond;
      }
      else if (whichButton == jbDivide)
      {
         dblAnswer = dblFirst / dblSecond;
      }
      else if (whichButton == jbRemainder)
      {
         dblAnswer = dblFirst % dblSecond;
      }
      else if (whichButton == jbClear)
      {
         jtxtFirst.setText("");
         jtxtSecond.setText("");
         jtxtAnswer.setText("");
         return;
      }
      else
      {
         // we omitted a test for one of our buttons. programmer error
         // handle as you will
      }

      jtxtAnswer.setText(dblAnswer + "");
    }
}