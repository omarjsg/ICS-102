import java.util.InputMismatchException;
import java.util.Scanner;
public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sa, ca, r, d, L, ga ;
		Scanner kb = new Scanner(System.in);
		try {
			System.out.println("Enter the area of the square [sq	cm]:");
			sa = kb.nextDouble();
			L = Math.sqrt(sa);
			d = Math.sqrt((L*L)+(L*L));
			r = d / 2;
			ca = Math.PI*Math.pow(r,2);
			ga = ca-sa;
			
			System.out.printf("Green area = %.2f square cm", ga);
		
		}
		catch (InputMismatchException	e)
		{
	}

	}
		}
