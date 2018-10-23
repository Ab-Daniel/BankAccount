public class BankAccount
{
	public BankAccount( )
	{
		balance = 0;
	}

	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}

	public void deposit(double amount)
	{
		balance = balance + amount;
	}

	public void withdraw(double amount)
	{
		balance = balance - amount;
	}

	public double getBalance( )
	{
		return balance;
	}

	public void transfer(BankAccount other, double amount)
	{
		withdraw(amount);
		other.deposit(amount);
	}

	public String toString( )
	{
		return "Balance: " + String.format("$%1.2f", balance);
	}

	private double balance;

}

