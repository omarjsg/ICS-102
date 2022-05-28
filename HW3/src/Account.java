import java.io.*;
class Account 
{
	public Account(String name, String dob) throws FileNotFoundException 
	{
		AccessAccount account = new AccessAccount(name,dob);
		if(account.check())
		{
			NewAccount create = new NewAccount(name,dob,0);
			create.getID();
			create.generatePassword();
			create.createAccount();
		}
		else
		{
			throw new IllegalArgumentException("Error: The entered account information has been already used.");
		}
	}
	public Account(String name, String dob, double amount) throws FileNotFoundException 
	{
		AccessAccount account = new AccessAccount(name,dob);
		if(account.check())
		{
			NewAccount create = new NewAccount(name,dob,amount);
			create.getID();
			create.generatePassword();
			create.createAccount();
		}
		else
		{
			throw new IllegalArgumentException("Error: The entered account information has been already used.");
		}
	}
	public Account(String name, String pass, String trans, double amount) throws FileNotFoundException 
	{
		AccessAccount transaction = new AccessAccount(name,pass,trans,amount);
		transaction.checkAccount();
		transaction.getBalance();
		transaction.doTransaction();
		transaction.addTransaction();
	}
}