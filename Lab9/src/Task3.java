import java.util.*;
public class Task3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		try{
			System.out.println("Enter number of seconds [as an integer]: ");
			int seconds = kb.nextInt();
			int[] time = new int[3];
			time = getTime(seconds);
			System.out.printf("%d seconds = %d hours, %d minuts, and %d seconds. ", seconds, time[0], time[1], time[2]);
		}
		catch(InputMismatchException e) 
		{
			System.out.println("Error"+e);
		}
		catch(IllegalArgumentException r)
		{
			System.out.println("Error: "+r);
		}
	}
	private static int[] getTime(int s) {
		int time[] = new int[3];
		if (s <0 )
		{
			throw new IllegalArgumentException();
		}
		else 
		{	
		int hour = (s/3600);
		int hourremainder = (s%3600);
		int minutes = hourremainder/60;
		int minutesremainder = (hourremainder)%60;
		time[0]= hour;
		time[1]=minutes;
		time[2]=minutesremainder;
		return time;
		}
	}

}
