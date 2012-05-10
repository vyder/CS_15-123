public class Top  // this is the TOP level class
{
	private int j = 5; // note this is non-static variable
	
	public static void main(String[] args)
	{
		Top.Static sic = new Top.Static();
		Top tl = new Top();
		Top.NonStatic nsc = tl.new NonStatic();
	}
	public static class Static  // static Inner class
	{
   		static int x = 6;
		Static() 
    	{
			System.out.println("Static Constructor just fired");
   			// Can't access non static 'j'
		}
  	}
	public class NonStatic // non static Inner class
	{
   		NonStatic()
		{
   			System.out.println("Value: " + j);
   		}
  	}
	
}

