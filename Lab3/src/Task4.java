import java.util.InputMismatchException;
import java.util.Scanner;
public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int yob,yob1, cy, age;
		String ln;
		char mn,fn;
		Scanner kb = new Scanner(System.in);
		try {
			System.out.println("Enter your year of birth: ");
			yob = kb.nextInt();
			yob1 = yob;
			cy = 2020;
			age = cy-yob1;
			kb.nextLine();
			System.out.println("Enter your last name: ");
			ln = kb.nextLine();
			
			
			System.out.println("Enter your first initial: ");
			fn = kb.nextLine().toUpperCase().charAt(0);
			
			
			System.out.println("Enter your middle initial: ");
			mn = kb.nextLine().toUpperCase().charAt(0);
			
			System.out.println("Mr "+fn+". "+mn+". "+ln+" your age is "+age);
			
		}
		catch (InputMismatchException	e)
		{
			System.out.println("Error: Invalid input");
		}
	}

}
