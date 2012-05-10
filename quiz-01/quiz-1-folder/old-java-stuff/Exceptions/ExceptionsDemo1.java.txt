/*
	ExceptionsDemo1.java

	- illustrates unchecked exception
		* Integer.parseInt()
		* works same with Double.parseDouble() and the other wrapper classes
*/

import java.io.*;

public class ExceptionsDemo1
{
	public static void main( String args[] )
	{
		System.out.println("calling foo1()");
		foo1();
		System.out.println("back from foo1()");
		System.out.println("returning from main()");
	} //END main

	public static void foo1()
	{
		System.out.println("In foo1()");
		System.out.println("calling foo2()");
		foo2();
		System.out.println("back from foo2()");
		System.out.println("returning from foo1()");
	}


	public static void foo2()
	{
		System.out.println("In foo2()");

		int i;
		double d;
		String s;

		s = "1234";
		i = Integer.parseInt( s );
		System.out.println("You entered int: " + i );

		s = "fubar";
		i = Integer.parseInt( s ); // this will throw a "NumberFormatException"
		System.out.println("You entered int: " + i );

		System.out.println("returning from foo2()");
	}
} //EOF
