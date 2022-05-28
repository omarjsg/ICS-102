import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class AccessAccount {
	private String name, password, dob, trans;
	private int ID;
	private double balance,amount;
	public AccessAccount(String name, String dob) 
	{
		this.name = name;
		this.dob = dob;
	}
	public AccessAccount(String name, String pass, String trans, double amount) 
	{
		this.trans = trans;
		this.amount = amount;
		this.name = name;
		this.password = pass;
	}
	//Used in case 1 & 2 to check that the new account information is already exist.
	public boolean check() throws FileNotFoundException
	{
		boolean status = true;
		String filename = "";
		String filedob = "";
		FileInputStream info = new FileInputStream("accountInfo.txt");
		Scanner FileInfo = new Scanner(info);
		FileInfo.nextLine();
		while (FileInfo.hasNextLine())
		{
			filename = FileInfo.next();
			FileInfo.next();
			FileInfo.nextInt();
			filedob = FileInfo.next();
			if(name.equals(filename) && dob.equals(filedob))
			{
				status = false;
				break;
			}
			else
			{
				status = true;
			}
		}
		FileInfo.close();
		return status;
	}
	//used in case 3 & 4 to check that if the entered account information are valid.
	public void checkAccount() throws FileNotFoundException,IllegalArgumentException
	{
		int id;
		String filename = "";
		String filepassword = "";
		FileInputStream info = new FileInputStream("accountInfo.txt");
		Scanner FileInfo = new Scanner(info);
		boolean found = false;
		FileInfo.nextLine();
		while (!found && FileInfo.hasNextLine())
		{
			filename = FileInfo.next();
			filepassword = FileInfo.next();
			id = FileInfo.nextInt();
			FileInfo.next();
			if(filename.equals(this.name) && filepassword.equals((this.password)))
			{
				this.ID = id;
				found = true;
			}
		}
		FileInfo.close();
		if(!found)
		{
			throw new IllegalArgumentException("Error: Invalid name or password.");
		}

		
	}
	//To get the last modified balance.
	public void getBalance() throws FileNotFoundException
	{
		FileInputStream Balance = new FileInputStream("balanceSheet.txt");
		Scanner FileBalance = new Scanner(Balance);
		FileBalance.nextLine();
		while(FileBalance.hasNextLine())
		{
			FileBalance.next();
			int fileID = FileBalance.nextInt();
			FileBalance.nextDouble();
			FileBalance.next();
			FileBalance.next();
			double total = FileBalance.nextDouble();
			if(fileID == this.ID)
			{
				this.balance = total;
			}
		}
		FileBalance.close();
	}
	//To conduct the transaction.
	public void doTransaction() throws IllegalArgumentException
	{
		if(amount >=0) {
			if (trans.equals("deposit")) 
			{
				balance += amount;
				System.out.printf("DIPOSIT\n%s\nThe amount %.1f has been deposited to the account %d\n",getDate() ,amount,ID);
			}
			else
			{
				if(amount<= balance){
					balance -= amount;
					System.out.printf("DIPOSIT\n%s\nThe amount %.1f has been withdrawn to the account %d\n",getDate() ,amount,ID);
				}
				else
				{
					throw new IllegalArgumentException("Error: No enough money.");
				}

			}
		}
		else
		{
			throw new IllegalArgumentException("Error: Invalid amount of transaction.");
		}
	}
	//To add the transaction in file.
	public void addTransaction() throws FileNotFoundException
	{
		FileOutputStream Balance = new FileOutputStream("balanceSheet.txt",true);
		PrintWriter transprinter = new PrintWriter(Balance);
		transprinter.print("\n" + name + " " + ID + " " + amount + " deposit\t" + getDate() + "\t" + balance);
		transprinter.close();
	}
	//To get the date.
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat formatOfDate = new SimpleDateFormat ("dd/MM/yyyy");
		return formatOfDate.format(date);
	}
}