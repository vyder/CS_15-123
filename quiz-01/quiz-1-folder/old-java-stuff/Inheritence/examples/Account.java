// Account class:  stripped down version, no setters
public class Account 
{
	private String name;
    	private double balance;
      public Account(String name, double balance) 
      {
		this.name = name;
		this.balance = balance;
	}
	public String getName()  
	{
		return name;
	}
	public double getBalance() 
	{
		return balance;
 	}
	public void deposit(double amount)
	{
		balance += amount;
	}
	public void withdrawal(double amount)
	{
		if (balance >= amount)
			balance -= amount;
		// else handle NSF condition
	}
	// transfers funds OUT of this account To another account
	public void transferTo( Account other, double amount )
	{
		if (balance >= amount)
		{
			other.deposit( amount ); // deposit into otheraccount
			withdrawal( amount );     // withdrawl from this account 
		}
		// else handle NSF condition
	}
	
	public String toString()
	{
		return name + " $" + balance ;
	}
}
