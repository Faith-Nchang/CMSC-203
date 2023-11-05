
public class CheckingAccount extends BankAccount{
	private static final int FEE = 15;
	
	
	 /**
	  * 
	  * @param name
	  * @param amount
	  */
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		String accountNum = super.getAccountNumber() + "-10";
		super.setAccountNumber(accountNum);
		
	}
	
	
	public boolean withdraw(double amount)
	{
		amount +=(FEE /100.0);
		if(super.withdraw(amount))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
