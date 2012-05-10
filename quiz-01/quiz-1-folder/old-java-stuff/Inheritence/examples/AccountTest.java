class AccountTest 
{
	public static void main(String args[]) {
	Account customer1 = new Account("Mike",0);
	System.out.println(Check.getName());
	System.out.println(Check.getBalance());
	Check.deposit(50);
	System.out.println(Check.getBalance());
  }
}

