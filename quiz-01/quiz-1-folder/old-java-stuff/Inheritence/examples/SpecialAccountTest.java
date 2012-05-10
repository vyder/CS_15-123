public class SpecialAccountTest 
{
	public static void main(String args[])
	{
		SpecialAccount cust1 = new SpecialAccount("J",100.00,.10);
		System.out.println(cust1.getName());
		cust1.deposit(100.00);
		System.out.println(cust1.getBalance());
		System.out.println(cust1.getPercent());
    	}
}

// Again for space saving - we put our class def in soam file as main App
class SpecialAccount extends Account 
{
	double percent;
	public SpecialAccount(String param,double bal,double pc)
	{
		super(param,bal); // calling parent C'Tor
		percent = pc;
	}
	public double getPercent()
	{
		return percent;
	}
}