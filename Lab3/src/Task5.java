import java.util.Scanner;
import java.util.InputMismatchException;
public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ebs, ays,rb1,rb2;
		
		Scanner kb = new Scanner(System.in);
		try {
			System.out.println("Enter Base salary :");
			ebs = kb.nextDouble();
			kb.nextLine();
			System.out.println("Enter actual number of service  :");
			ays = kb.nextDouble();
			rb1 = (ebs)*(ays);
			rb2 = (ebs)*(Math.floor(ays));
			System.out.println("Retirement benifit1 = ["+ebs+"*"+ays+"] = " +rb1+" Saudi Riyals");
			System.out.println("Retirement benifit2 = ["+ebs+"*"+ Math.floor(ays)+"] = " +rb2+" Saudi Riyals");
		}
		catch (InputMismatchException	e)
		{
			System.out.println("Error404");
		}
		}
	}


