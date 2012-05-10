// Account Transfer passes one account object into a 
// member method of another account object

public class AccountTransfer
{
    public static void main(String args[])
    {
		// initilize a couple Accounts 
		
        Account cust1 = new Account("Michael",100.00);
        Account cust2 = new Account("Joel",200.00);
        
		// echo accounts after initialization
		System.out.println(cust1);
        System.out.println(cust2);
		
		System.out.println("Xferring $50.00 from " + cust1.getName() + " to " + cust2.getName() );
        cust1.transferTo(cust2, 50.00);
       
		// echo accounts after transfer
		System.out.println(cust1);
        System.out.println(cust2);	
    } //END main
}
