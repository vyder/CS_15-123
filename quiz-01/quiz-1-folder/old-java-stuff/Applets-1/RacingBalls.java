
import java.awt.*;  //  graphics: draw Color etc.
import java.awt.event.*; // events
import javax.swing.*; // the Swing widgets: JButton etc.
import java.util.*;

public class RacingBalls extends JApplet implements ActionListener
{
    // declare JButtons at this level so we don't have to pass them around.
    // we need access to these names in multiple scopes

    public JButton jbResetBalls, jbStartRace, jbClearScreen; // need access in init() and in handler
    Container content;   // need access in init() and in handler

	final int DIAM = 50;
	int redX,redY,greenX,greenY,blueX,blueY;
	Random r;

    public void init()
    {
		r = new Random();
        // you can't add widgets directly onto a JApplet - you add them to the ContentPane
        content = getContentPane();

        content.setBackground(Color.white);  // set ContentPane's background to white
        content.setLayout(new FlowLayout()); // widgets bubble to top, centered

        jbResetBalls = new JButton("ResetBalls");  // button is created with caption "Red"
        jbStartRace = new JButton("StartRace"); // button with caption "Green"
        jbClearScreen = new JButton("ClearScreen");

        // order of adding is important, bubble to top, left to right, centered

        content.add(jbResetBalls);
        content.add(jbStartRace);
        content.add(jbClearScreen);

        jbResetBalls.addActionListener(this);
        jbStartRace.addActionListener(this);
        jbClearScreen.addActionListener(this);

    }// END init

	void resetBalls()
	{
		redX=greenX=blueX=0;
		redY =   2 * content.getHeight() / 5;
		greenY = 3 * content.getHeight() / 5;
	    blueY =  4 * content.getHeight() / 5;
		drawBalls();
	}
	void drawBalls()
	{
		Graphics g = getGraphics();
		// draw Red Ball
		g.setColor( Color.red );
		g.drawOval( redX, redY, DIAM, DIAM );

		// draw Green Ball
		g.setColor( Color.green );
		g.drawOval( greenX, greenY, DIAM, DIAM );

		// draw Blue Ball
		g.setColor( Color.blue );
		g.drawOval( blueX, blueY, DIAM, DIAM );
	}
	void eraseBalls()
	{
		Graphics g = getGraphics();
		g.setColor( Color.white );

		g.drawOval( redX, redY, DIAM, DIAM );
		g.drawOval( greenX, greenY, DIAM, DIAM );
		g.drawOval( blueX, blueY, DIAM, DIAM );
	}
	void clearScreen()
	{
		Graphics g = getGraphics();
		g.setColor( Color.white );
		int fifthY = content.getHeight()/5;
		g.fillRect( 0, fifthY, content.getWidth(), content.getHeight() - fifthY );

	}
	void startRace()
	{
		while ( redX+DIAM < content.getWidth() &&
		        greenX+DIAM < content.getWidth() &&
				blueX+DIAM < content.getWidth() )
		{
			eraseBalls();

			// for each ball generate a *seperate* random number from
			// 1 to DIAM/2 - add that random to that ball

			redX += r.nextInt( DIAM/2 ) + 1;
			greenX += r.nextInt( DIAM/2 ) + 1;
			blueX += r.nextInt( DIAM/2 ) + 1;

			// redraw balls at new x,y coords
			drawBalls();

			// sleep/delay for a fraction of a second (THREADS!)
		}
	}
    public void actionPerformed( ActionEvent e ) // actionPerformed is the interface method we MUST override
    {
       // unfortunately you CAN'T CASE out test for buttons - use IFs
            Object whichButton = e.getSource();
            if (whichButton == jbResetBalls)
			{  showStatus("Just Reset Balls");
				resetBalls();
			}
            else if (whichButton == jbStartRace)
			{
                showStatus("Just Started Race");
				startRace();
			}
            else if (whichButton == jbClearScreen)
			{
                showStatus("Screen Cleared");
				clearScreen();
			}
			else
            {
                showStatus("Unexpected Event");
            }
        } // END actionPerformed

} //EOF