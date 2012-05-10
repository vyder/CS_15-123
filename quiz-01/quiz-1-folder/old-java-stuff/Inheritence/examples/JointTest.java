public class JointTest
{
	public static void main(String args[])
	{ 
		Account cust1 = new Account("Mike",100.00);
		Account cust2 = new Account("Sue",200.00); 
		Joint partners = new Joint(cust1,cust2);
		partners.print();
		System.out.println("'Joint' balance is: " + partners.getBalance());
	}
}

// Notice we include our class defintion INSIDE the same filer as the App
// this is not-typical but it saves space.
class Joint 
{
	private Account first;  // Composition - data member is itself a class
	private Account second; // Composition - data member is itself a class
	public Joint(Account f, Account s)
	{
		first = f;
		second = s;
	}
	public double getBalance()
	{
		return first.getBalance() + second.getBalance();
	}
	public void print()
	{
		System.out.println(first);
		System.out.println(second );
	}
}

