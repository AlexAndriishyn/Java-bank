package source;

import java.util.ArrayList;

public class Customer
{
	private String firstName;
	private String lastName;
	private String sin;
	private String address;

	private final static int ACCT_LIMIT = 2;
	private static Account acct_temp; // Account class wrapper
	private ArrayList<Account> acctList; // Collection for holding account records

	/**
	 * Default constructor with no parameters
	 */
	public Customer()
	{

	}

	/**
	 * Constructor with parameters
	 * 
	 * @param firstName
	 * @param lastName
	 * @param sin
	 * @param address
	 */
	public Customer(String firstName, String lastName, String sin, String address)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.sin = sin;
		this.address = address;
		acct_temp = new Account();
		this.acctList = new ArrayList<Account>();
		this.acctList.add(acct_temp);
	}

	/**
	 * Creates an account if account limit is not exceeded and adds it to account list
	 */
	public boolean createAcct()
	{
		if (acctList.size() < ACCT_LIMIT)
		{
			acct_temp = new Account();
			this.acctList.add(acct_temp);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * First name mutator
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Last name mutator
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * SIN mutator
	 * 
	 * @param sin
	 */
	public void setSin(String sin)
	{
		this.sin = sin;
	}

	/**
	 * Address mutator
	 * 
	 * @param address
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * First name accessor
	 *
	 * @return Customer's first name.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}

	/**
	 * Last name accessor
	 * 
	 * @return Customer's last name
	 */
	public String getLastName()
	{
		return this.lastName;
	}

	/**
	 * SIN accessor
	 * 
	 * @return Customer's passport ID
	 */
	public String getSin()
	{
		return this.sin;
	}

	/**
	 * Address accessor
	 * 
	 * @return Customer's address
	 */
	public String getAddress()
	{
		return this.address;
	}

	/**
	 * Account accessor
	 * 
	 * @param acctNumber
	 * @return Customer's account, specified by the account ID, acctId
	 */
	public Account getAccount(int acctNumber)
	{
		int index = -1; // Variable to hold the index of the account we look for

		// This loop searches for the account with a given account number
		for (Account account : acctList)
		{
			if (account.getAcctNumber() == acctNumber)
				index = this.acctList.indexOf(account);
		}

		return this.acctList.get(index);
	}

	/**
	 * Account list accessor
	 * 
	 * @return An account list of a customer
	 */
	public ArrayList<Account> getAcctList()
	{
		return this.acctList;
	}

	@Override
	public String toString()
	{
		return String.format("Name: %20s | Surname: %20s | SIN: %20s | Address: %20s",
				this.getFirstName(), this.getLastName(), this.getSin(), this.getAddress());
	}
}

