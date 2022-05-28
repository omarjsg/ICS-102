import java.util.InputMismatchException;
import java.lang.ArithmeticException;
import java.util.Scanner;
public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nc, np, ncp, nrc;
		Scanner kb = new Scanner(System.in);
		try {
			System.out.println("Enter number of camels [>0] and number of people[>0]: ");
			nc = kb.nextInt();
			np = kb.nextInt();
			ncp = nc/np;
			nrc = nc%np;
			System.out.println("Number of camels per person = "+ ncp +"\nnumber of remaining camels = "+ nrc);
			
		}
		catch (InputMismatchException	e)
		{
			System.out.println("Error : One or both input not integer.");
		}	
		catch (ArithmeticException  e)
		{
			System.out.println("Error : number of people is zero.");
		}
		
	}

}
