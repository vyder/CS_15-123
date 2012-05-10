import java.io.*;
public class Demo5
{
	public static void main( String args[] )
	{
		BufferedReader kbd = new BufferedReader( new InputStreamReader( System.in ));
		String response;

		System.out.print("Enter a positive number: ");
		try
		{
			response = kbd.readLine();
			int n = Integer.parseInt( response );
			if ( n < 0 )
				throw new Exception("Negative Number Exception! Enter a number > 0 next time");
		}
		catch (IOException ioe)
		{
			System.out.println( ioe );
			System.exit(0);
		}
		catch (NumberFormatException nfe)
		{
			System.out.println( nfe );
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println( e );
			System.exit(0);
		}

	}
} //EOF
