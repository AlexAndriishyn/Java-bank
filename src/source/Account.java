package source;

public class Account
{
	private int acctNumber;
	private double acctBalance;
	private final static double MAX_WITHDRAWAL = 1000.0;
	private int transactionCount = 0;

	/**
	 * Constructor without balance
	 */
	public Account()
	{
		this.setAcctNumber(); // Assigning an account number
		this.acctBalance = 0.0; // Initial account balance is set to 0
	}

	/**
	 * Constructor with balance
	 * 
	 * @param acctBalance
	 */
	public Account(double acctBalance)
	{
		this.setAcctNumber();
		this.acctBalance = acctBalance;
	}

	/**
	 * retrieves account number from account support class
	 * and assigns it to the new account
	 */
	private void setAcctNumber()
	{
		this.acctNumber = Account_Support.getAcctNumber();
	}

	/**
	 * Adds a specified amount of currency to the account balance
	 * 
	 * @param amount
	 * @return true if transaction was successful, false otherwise
	 */
	public boolean Deposit(double amount)
	{
		if (amount > 0.0)
		{
			++this.transactionCount;
			return updateAcctBalance(amount);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Withdraws a specified amount of currency from the account balance
	 * 
	 * @param amount
	 */
	public boolean Withdraw(double amount)
	{
		if (acctBalance >= amount && amount <= MAX_WITHDRAWAL && amount > 0)
		{
			amount *= -1; // Multiply by negative -1 to extract the amount of withdraw from account balance
			++this.transactionCount;
			return updateAcctBalance(amount);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Updates the account balance with the specified amount
	 * 
	 * @param amount
	 */
	private boolean updateAcctBalance(double amount)
	{
		this.acctBalance += amount;
		return true;
	}

	/**
	 * Account number accessor
	 * 
	 * @return Account number
	 */
	public int getAcctNumber()
	{
		return this.acctNumber;
	}

	/**
	 * Account balance accessor
	 * 
	 * @return Account balance
	 */
	public double getAcctBalance()
	{
		return this.acctBalance;
	}

	/**
	 * Transaction count accessor
	 * 
	 * @return Number of transactions of this account
	 */
	public int getAcctTransactionCount()
	{
		return this.transactionCount;
	}

	/**
	 * Maximum withdrawal accessor
	 * 
	 * @return Maximum withdrawal amount
	 */
	public double getMaxWithdrawal()
	{
		return MAX_WITHDRAWAL;
	}

	@Override
	public String toString()
	{
		return String.format("Account# %17d | Balance: %20.2f | Transactions: %11d |",
				this.getAcctNumber(), this.getAcctBalance(), this.getAcctTransactionCount());
	}
}
