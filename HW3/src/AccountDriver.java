import java.util.*;
import java.io.*;
public class AccountDriver {
	public static void main(String[] args) throws FileNotFoundException 
	{
		String name = null, dob = null, pass = null;
		int ch = 0,day = 0,month = 0, year=0;
		double amount = 0;
		Scanner kb = new Scanner(System.in);
		do
		{
			try {
				System.out.println("Enter your choice (1-5):");
				System.out.print("\n 1. Create new account without deposit");
				System.out.print("\n 2. Create new account with deposit an amount");
				System.out.print("\n 3. Deposit an amount to an existing account");
				System.out.print("\n 4. Withdraw an amount from an account");
				System.out.print("\n 5. Exit");
				System.out.print("\n\n Enter your choice: ");
				ch = kb.nextInt();
				kb.nextLine(); 
				switch(ch) 
				{
				//Create new account without deposit.
				case 1: System.out.println("Enter name: ");
				name = kb.nextLine();
				do 
				{
					System.out.println("Enter date of birth as day month year(e.g. 23 12 2001):");
					System.out.print("Day: ");
					day = kb.nextInt();
					System.out.print("Month: ");
					month = kb.nextInt();
					System.out.print("Year: ");
					year = kb.nextInt();
				}
				while(checkInput(day,month,year));
				dob = (day+"/"+month+"/"+year);
				new Account(name, dob);
				break;
				case 2: System.out.println("Enter name: ");
				name = kb.nextLine();
				do 
				{
					System.out.println("Enter date of birth as day month year(e.g. 23 12 2001):");
					System.out.print("Day: ");
					day = kb.nextInt();
					System.out.print("Month: ");
					month = kb.nextInt();
					System.out.print("Year: ");
					year = kb.nextInt();
				}
				while(checkInput(day,month,year));
				dob = (day+"/"+month+"/"+year);
				System.out.println("Enter initial deposit amount: ");
				amount = kb.nextDouble();
				new Account(name, dob, amount);
				break;
				case 3:  System.out.print("Enter name: ");
				name = kb.nextLine();
				System.out.print("Enter password: ");
				pass = kb.nextLine();
				System.out.print("Enter amount to be deposited: ");
				amount = kb.nextDouble();
				new Account(name,pass,"deposit",amount);
				break;
				case 4:  System.out.print("Enter name: ");
				name = kb.nextLine();
				System.out.print("Enter password: ");
				pass = kb.nextLine();
				System.out.print("Enter amount you want to withdraw: ");
				amount = kb.nextDouble();
				new Account(name,pass,"withdraw",amount);
				break;
				case 5:  System.out.println("Exit.");
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Error: Invalid Input.");
				System.out.println();
				kb.nextLine();
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e);
				System.out.println();
				kb.nextLine();
			}
		}
		while(ch!=5);
		kb.close();
	}
	//To check the date of birth if it is valid or not.
	private static boolean checkInput(int day, int month, int year) 
	{
		boolean checkInput;
		checkInput=false; 
		if(day<0 || day>31) 
		{
			System.out.println("Invalid day");
			checkInput=true;    
		}
		if(month<0 || month>31) 
		{
			System.out.println("Invalid Month");
			checkInput=true;
		}
		return checkInput;
	}
}