//Project members:  
//Name:					ID:			Section#:
// Omar AlGhamdi		201855000	55	
// AbdulAziz AlLohayb	201861340	57
import java.io.*;
import java.util.*;
public class AccountDrver {
	public static void main(String[] args) throws FileNotFoundException {
		int id;
		double amount;
		System.out.println("Welcome to Omar & AbdulAzizs' ICS 102 lab project for Term (192) ...");
		System.out.println("This project is about simuating an ATM ...");
		EnterKey();
		int choice = 0;
		Account accounts = new Account();
		try {
			Account[] accountsArray = accounts.loadAccounts().clone();
			Account DummyAccount = new Account();
			do {
				try {
					Scanner kb = new Scanner(System.in); // Scanner is inside the loop since when InputMismatch Exception occur it will delete the previous input.
					System.out.println("Control menu:\n1. Display Account Info for all Accounts\n" + "2. Display Account Info for a particular Account\n" + "3. Withdraw\n" + "4. Deposit\n" + "5. Transfer\n" + "6. Add New Account\n" + "7. Delete Account\n" + "8. Exit\n");
					System.out.println("Please select your choice: ");
					choice = checkChoice();				
					switch(choice)
					{
					//To display all accounts and their info.
					case 1: 
						accounts.displayAccounts(accountsArray);
						EnterKey();
						break;
						//To display a certain account info.
					case 2:
						System.out.println("Please enter accountID: ");
						id = kb.nextInt();
						DummyAccount.setID(id); 
						if(checkID(DummyAccount,accountsArray))
						{
							int index = accounts.theIndex(DummyAccount,accountsArray);
							System.out.println(accountsArray[index].toString(choice));
						}
						else
						{
							System.out.println("Error: Invalid account number");
						}
						EnterKey();
						break;
						//To withdraw an amount of money.
					case 3:
						System.out.println("Please enter accountID:   ");
						id = kb.nextInt();
						DummyAccount.setID(id);
						if(checkID(DummyAccount,accountsArray))
						{
							System.out.println("Please enter withdraw amount (SAR):  ");
							amount = kb.nextDouble();
							int index = accounts.theIndex(DummyAccount,accountsArray);
							accountsArray[index].withdraw(amount);
							System.out.println(accountsArray[index].toString(choice));
						}
						else
						{
							System.out.println("Error: Invalid account number");
						}
						EnterKey();
						break;
						//To deposit an amount of money/
					case 4:
						System.out.println("Please enter accountID: ");
						id = kb.nextInt();
						DummyAccount.setID(id);
						if(checkID(DummyAccount,accountsArray))
						{
							System.out.println("Please enter deposit amount (SAR):  ");
							amount = kb.nextDouble();
							int index = accounts.theIndex(DummyAccount,accountsArray);
							accountsArray[index].deposit(amount);
							System.out.println(accountsArray[index].toString(choice));
						}
						else
						{
							System.out.println("Error: Invalid account number");
						}
						EnterKey();
						break;
						//To transfer an amount of money to a specific account.
					case 5:
						System.out.println("Please enter source accountID: ");
						int id1 = kb.nextInt();
						DummyAccount.setID(id1);
						int index1 = accounts.theIndex(DummyAccount,accountsArray);
						if(checkID(DummyAccount,accountsArray))
						{
							System.out.println("Please enter destination accounID: ");
							int id2 = kb.nextInt();
							DummyAccount.setID(id2);
							if(checkID(DummyAccount,accountsArray))
							{
								System.out.println("Please enter transfer amount (SAR):  ");
								amount = kb.nextDouble();
								accountsArray[index1].transfer(amount,DummyAccount,accountsArray);
								System.out.println(accountsArray[index1].toString(choice));
							}
							else
							{
								System.out.println("Error: Invalid destination account ID. ");
							}
						}
						else
						{
							System.out.println("Error: Invalid source account ID");
						}
						EnterKey();
						break;
						//To create a new account.
					case 6:
						System.out.println("Please enter the first name: ");
						try {
						String name1 = kb.next();
						for (int index = 0; index < name1.length(); index++)
						{
							if (!Character.isLetter(name1.charAt(index))) // In case the user entered wrong name format. 
							{
								throw new InputMismatchException();
							}
						}
						char FL = name1.toUpperCase().charAt(0);
						name1 = FL+name1.substring(1, name1.length());
						System.out.println("Please enter the family name: ");
						String name2 = kb.next();
						for (int index = 0; index < name2.length(); index++)
						{
							if (!Character.isLetter(name2.charAt(index)))
							{
								throw new InputMismatchException();
							}
						}
						FL = name2.toUpperCase().charAt(0);
						name2 = FL+name2.substring(1, name2.length());
						System.out.println("Enter initial deposit amount: ");
						double DepositAmount = kb.nextDouble();
						Account[] newAccounts = accounts.createAccount(accountsArray,name1,name2,DepositAmount);
						accountsArray = newAccounts.clone(); // replacing the old array with new one.
						System.out.println(accountsArray[newAccounts.length-1].toString(choice));	//The index is length  - 1 because it will print the last added account.
						}
						catch(InputMismatchException e)
						{
							System.out.println("Error: Invalid input, names should be written in English alphabet letters only. ");	
						}
						EnterKey();
						break;
						//To delete a specific account.
					case 7:
						System.out.println("Please enter account ID: ");;
						id = kb.nextInt();
						DummyAccount.setID(id);
						if(checkID(DummyAccount,accountsArray))
						{
							System.out.println("Are you sure about deleting the selected account ( ID: "+id+" ) ?\n1: Yes\t\t2:No"); //Deleting account is serious so it is better to make sure that the user has not mistaken.
							int ch = kb.nextInt();
							if(ch == 1) {
								int index = accounts.theIndex(DummyAccount,accountsArray);
								String name = accountsArray[index].getName();
								id = accountsArray[index].getAccountID();
								System.out.println(accountsArray[index].toString(choice));
								Account[] deleteAccount =accounts.deleteAccount(accountsArray,index);
								accountsArray = deleteAccount.clone(); // replacing the old array with new one.
								System.out.printf("The account %d for %s has been deleted. %n", id, name);
								if(accountsArray.length <= 0)
								{
									System.out.println("#Note: The last account has been deleted.");
								}
							}
							else if (ch == 2)
							{
								break;
							}
							else{
								throw new IllegalArgumentException("Error: The available choices are 1 - 2."); 
							}
						}
						else
						{
							System.out.println("Error: Invalid account number");
						}
						EnterKey();
						break;
						//To print the array into the file and terminate the program.
					case 8:
						System.out.println("Thank you for choosing us. \nexit.");
						accounts.filePrint(accountsArray);
						System.exit(0);
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Error: Invalid Input. ");
					EnterKey();
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e);
					EnterKey();
				}
			}while (choice !=8);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Error: The file may have some errors.\n\nPlease check the contents of the file by the folowing:- \n\n1. Check that the information in this order: ID, first name, family name and balance ( If there are no information check there is no space in the first line ).\n2. Check that there is no space after the last element in the last line.\n3. Check that there is no additional line below the information.\n4. Restart the program.");
		}
	}
	//To continue.
	public static void EnterKey()
	{
		System.out.println("\nPress Enter key to continue . . .\n");
		Scanner kb = new Scanner(System.in);
		kb.nextLine();
	}
	//To check the if the choice of the user is valid.
	public static int checkChoice() throws IllegalArgumentException{
		Scanner kb = new Scanner(System.in);
		int choice = kb.nextInt();
		if(choice < 1 || choice > 8)
		{
			throw new IllegalArgumentException("Error: The available choices are (1 - 8).");
		}
		else
		{
			return choice;
		}
	}
	//To check if the ID is already exist.
	public static boolean checkID(Account targetVariable, Account[]accountsArray)
	{
		boolean status = false;
		for (int i = 0; i<accountsArray.length;i++ )
		{
			if(accountsArray[i].equals(targetVariable))
			{
				status = true; //This means that the id is already exist.
				break;
			}
			else
			{
				status = false; //This means that the id does not exist.
			}
		}
		return status;
	}
}