import java.util.*;
public class Task1 {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		instruction();
		try {
			int n; 
			n = kb.nextInt();
			double fact = factorial(n);
			System.out.printf("The approximate factorial o %d is %.6e", n,fact);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Error: "+e);
		}
		catch(IllegalArgumentException r)
		{
			System.out.println("Error: "+r);
		}
	}
	private static double factorial(int n )throws IllegalArgumentException{
		if (n<0 || n>143)
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			double fact = (Math.pow(n,n)*Math.pow(Math.E, -n))*(Math.sqrt(((2*n)+(1.0/3.0))*Math.PI));
			return fact;
		}
		
	}
	private static void instruction(){
		System.out.println("This program computes the approximate value of the factorial using the formula proposed by R. W. Gosper.");
		System.out.println("To use this program, input should not be negative. Also use values not greater than 143");
		System.out.println("\nEnter the value of n [ 0 <= n <= 143 ]: ");
		}
}
