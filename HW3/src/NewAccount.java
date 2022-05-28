import java.io.*;
import java.text.*;
import java.util.*;
public class NewAccount 
{
	private String name, dob, password = "",alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#_!%^&@";
	private double balance=0;
	private int ID = 0; 
	public NewAccount(String name, String dob, double amount) {
		this.name = name;
		this.dob = dob;
		this.balance = amount;
	}
	//to generate a new Id.
	public int getID() throws FileNotFoundException
	{
		int id = 0;
		FileInputStream info1 = new FileInputStream("accountInfo.txt");
		Scanner FileInfo1 = new Scanner(info1);
		FileInfo1.nextLine();
		while (FileInfo1.hasNextLine())
		{
			FileInfo1.next();
			FileInfo1.next();
			id = FileInfo1.nextInt();
			FileInfo1.next();
		}
		FileInfo1.close();
		if (id == 0)
		{
			id = 10000001;
			return this.ID = id;
		}
		else
		{
			id++;
			return this.ID = id;
		}
	}
	//To generate a new password.
	public String generatePassword()
	{
		int AlphaLength = alphabets.length();
		for (int index = 1; index <= 8; index++)
		{
			password += alphabets.charAt((int) (AlphaLength*Math.random()));
		}
		return password;
	}
	//to add the account to the file.
	public void createAccount() throws FileNotFoundException
	{
		FileOutputStream info = new FileOutputStream("accountInfo.txt",true);
		PrintWriter add = new PrintWriter(info);
		FileOutputStream Balance = new FileOutputStream("balanceSheet.txt",true);
		PrintWriter transprinter = new PrintWriter(Balance);
		add.print("\n"+name+"\t"+password+"\t"+ID+"\t"+dob);
		transprinter.print("\n" + name + " " + ID + " " + balance + " deposit\t" + getDate() + "\t" + balance);
		System.out.println(toString());
		add.close();
		transprinter.close();
	}
	//To get the Date.
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat formatOfDate = new SimpleDateFormat ("dd/MM/yyyy");
		return formatOfDate.format(date);
	}
	//To display the message to confirm the account creation.
	public  String toString()
	{
		return String.format("Your password: %s and Account ID: %d\n%s\nThe amount %.1f has been deposited to the newly created account!!", this.password, this.ID,getDate() ,this.balance);
	}
}