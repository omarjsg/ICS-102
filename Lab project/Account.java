import java.io.*;
import java.util.*;
public class Account 
{
	private int accountID;
	private String name, name1, name2;
	private double balance = 0, balanceBefore = 0, amount = 0;
	//This constructor is to define each element in the array.
	public Account(int id, String name1, String name2, double balance) 
	{
		this.name1 = name1;
		this.name2 = name2;
		this.accountID = id;
		this.name = name1+" "+name2;
		this.balance = balance;
	}
	//This constructor is to initialize DummyAccount.
	public Account() 
	{

	}
	//To get access to the balance in a specific account.
	public double getBalance() 
	{
		return balance;
	}
	//To get access to the ID in a specific account.
	public int getAccountID() 
	{
		return accountID;
	}
	//To get access to the name in a specific account.
	public String getName() 
	{
		return name;
	}
	//To deposit an amount of money + used in transfer.
	public void deposit(double  amount) throws IllegalArgumentException
	{
		if (amount >0) {
			balanceBefore = balance;
			this.amount = amount;
			balance = balance + amount;
		} 
		else 
		{
			throw new IllegalArgumentException("Error: Invalid deposit amount");
		}
	}
	//To withdraw an amount of money.
	public void withdraw(double   amount) throws IllegalArgumentException
	{
		if (amount <= this.balance && amount >0) {
			balanceBefore = balance;
			this.amount = amount;
			balance = balance-amount;
		} 
		else if (amount < 0) 
		{
			throw new IllegalArgumentException("Error: Invalid withdraw amount");
		}
		else if (amount > balance)
		{
			throw new IllegalArgumentException("Error: Insufficient balance. Balance available is only "+balance+" SAR");
		}
	}
	//To transfer an amount of money
	public void transfer(double  amount, Account  destinationAccount, Account[] accountsArray) throws IllegalArgumentException, FileNotFoundException
	{
		int index = theIndex(destinationAccount,accountsArray);
		double disBalance = accountsArray[index].getBalance();
		if (amount <= this.balance && amount >0) {
			balanceBefore = balance;
			this.amount = amount;
			balance = balance-amount;
			disBalance+=amount;
			accountsArray[index].setBalance(disBalance);
		} 
		else if (amount < 0) 
		{
			throw new IllegalArgumentException("Error: Invalid transfer amount");
		}
		else if (amount > balance)
		{
			throw new IllegalArgumentException("Error: Insufficient balance. Balance available is only "+balance+" SAR");
		}
	}
	//To set a new balance for transferred account.
	private void setBalance(double balance) 
	{
		this.balance = balance;
	}
	//To print the results to the user.
	public String toString(int choice) //Choice is included to ease choosing the output for each element in the array.
	{
		if (choice == 2) 
		{
			return String.format("AccountID : %d      Account Owner : %s              Account Balance: %.2f SAR",accountID, name,  balance);
		} else if (choice == 3)
		{
			return String.format("Balance before withdrawal : %,.2f Saudi Riyals\n" + "Amount withdrawn from Account: %,.2f Saudi Riyals\n" + "New Balance: %,.2f Saudi Riyals",balanceBefore, amount,  balance);
		}else if (choice == 4) 
		{
			return String.format("Balance before deposit : %,.2f Saudi Riyals\n" + "Amount deposited to Account: %,.2f Saudi Riyals\n" + "New Balance: %,.2f Saudi Riyals",balanceBefore, amount,  balance);
		}else if (choice == 5) 
		{
			return String.format("Balance before transfer : %,.2f Saudi Riyals\n" + "Amount transferred to Account: %,.2f Saudi Riyals\n" + "New source balance: %,.2f Saudi Riyals",balanceBefore, amount,  balance);
		}else if (choice == 6)
		{
			return String.format("New account has been created! %nAccount owner: %s %s %nNew account ID is: %d%nBalance = %.2f SAR",this.name1,this.name2,accountID,  balance);
		}
		return "";
	}
	//to display the accounts to the user.
	public void displayAccounts(Account[] accountsArray) throws FileNotFoundException 
	{
		if(accountsArray.length == 0)
		{
			throw new IllegalArgumentException("None accounts have been regestired, choose option 6 to add a new account."); 
		}
		System.out.println("AccountID\tAccount Owner\t  Account Balance(SAR)");
		for(int i = 0; i < accountsArray.length; i++)
		{
			int id = accountsArray[i].getAccountID();
			String name = accountsArray[i].getName();
			double balance = accountsArray[i].getBalance();
			System.out.printf("%d\t\t%s\t   %,.2f%n", id, name, balance);
		}
	}
	//This method is used to compare between entered and existed IDs.
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Account account = (Account)obj;
			return this.accountID == account.accountID;
		}
	}
	//to generate an array of accounts.
	public Account[] loadAccounts() throws FileNotFoundException, NoSuchElementException 
	{
		FileInputStream input = new FileInputStream("Accounts.txt");
		Scanner sizeReader = new Scanner(input);
		int size =0;
		while(sizeReader.hasNextLine()) // To define the size of the array.
		{
			sizeReader.nextLine();
			size++;
		}
		sizeReader.close();
		Account[] accountsArray = new Account[size];		
		int index = 0;
		FileInputStream input1 = new FileInputStream("Accounts.txt");
		Scanner info = new Scanner(input1);
		while(info.hasNextLine())
		{
			int id1 = info.nextInt();
			String name1 = info.next();
			String name2 = info.next();
			double balance = info.nextDouble();
			accountsArray[index] = new Account(id1,name1,name2,balance);
			index++;
		}
		info.close();
		return accountsArray;
	}
	//To initialize an ID to the dummy object.
	public void setID(int id) {
		this.accountID = id;	
	}
	//To get the index of the entered ID.
	public int theIndex (Account DummyAccount, Account[] account) 
	{
		int index;
		for (index = 0; index < account.length; index ++ )
		{
			if(account[index].equals(DummyAccount))
			{
				break;
			}
		}
		return index;
	}
	//To add new account to the accounts list.
	public Account[] createAccount(Account[] accountsArray,String name1, String name2, double damount)
	{ 
		if(damount < 0)
		{
			throw new IllegalArgumentException("Error: Inavlid deposit amount."); 
		}
		Account[] old = accountsArray.clone();
		int newSize = old.length+1; //To define the size of the new array.
		Account[] Accounts = new Account[newSize];
		for (int index =0; index < accountsArray.length; index++ )
		{
			Accounts[index] = old[index];
		}
		this.name = name1+" "+name2;
		Accounts[newSize-1] = new Account(maxID(old),name1,name2,damount);	
		return Accounts;
	}
	//To generate a new id foe new created account.
	public int maxID(Account[]accountsArray)
	{
		int maxID = 1000;
		for (int i = 0; i<accountsArray.length;i++ )
		{
			if(maxID < accountsArray[i].getAccountID())
			{
				maxID = accountsArray[i].getAccountID();
			}
		}
		return ++maxID;
	}
	//To delete a specific account from the list.
	public Account[] deleteAccount(Account[] accountsArray, int DeletedIndexndex) {
		Account[] deleted = accountsArray.clone();
		int newSize = deleted.length - 1; // to define the size of the new array.
		Account[] Accounts = new Account[newSize];	
		for (int index = 0; index < DeletedIndexndex; index++ )
		{
			Accounts[index] = deleted[index];
		}
		for (int index = DeletedIndexndex+1; index < accountsArray.length; index++ )
		{
			Accounts[index-1] = deleted[index];
		}
		return Accounts;
	}
	//To print the accounts into the file.
	public void filePrint(Account[] accountsArray) throws FileNotFoundException 
	{
		FileOutputStream output = new FileOutputStream("Accounts.txt");
		PrintWriter printer = new PrintWriter(output);
		if(accountsArray.length > 0)
		{
			int index;
			for( index = 0; index < accountsArray.length-1; index++)
			{
				int id = accountsArray[index].getAccountID();
				String name = accountsArray[index].getName();
				double balance = accountsArray[index].getBalance();
				printer.printf("%d\t\t%s\t   %.2f%n", id, name, balance);
			}
			int id = accountsArray[index].getAccountID();//Last line is outside the loop to avoid generating an empty line in the bottom of the file.
			String name = accountsArray[index].getName();
			double balance = accountsArray[index].getBalance();
			printer.printf("%d\t\t%s\t   %.2f", id, name, balance);
		}
		printer.close();
	}
}