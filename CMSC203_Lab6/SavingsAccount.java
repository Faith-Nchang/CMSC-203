
public class SavingsAccount extends BankAccount {
	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double balance)
	{
		super(name, balance);
		accountNumber = super.getAccountNumber() +"-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount account, int balance)
	{
		super(account, balance);
		savingsNumber+=1;
		accountNumber = super.getAccountNumber() +"-" + savingsNumber;
	}
	
	public void postInterest()
	{
		double amount = super.getBalance() * (rate / 12);
		super.deposit(amount);
	}
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
}
