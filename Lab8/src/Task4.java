import java.util.*;
public class Task4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int corners = 0,size =0 , i = 0;
		double xelement = 0, yelement = 0, sum = 1, area = 0;
		try {
			do {
				System.out.println("Enter the number of corners >2: ");
				corners = kb.nextInt();
				if (corners < 3) {
					System.out.println("\nError: please enter a number of corner > 2");
				} else {
					continue;
				}
			} while (corners < 3);
			size = corners+1;
			double x[]= new double[size];
			double y[]= new double[size];
			for(i = 0; i < corners; i++) {
				System.out.printf("Enter x,y coordenates for corner %d: ",i+1);
				xelement = kb.nextDouble();
				x[i]= xelement;
				yelement = kb.nextDouble();
				y[i] = yelement;
			}
			x[corners]= x[0];
			y[corners]= y[0];
			for(i = 1; i <= corners; i++) {
				sum = sum + ((x[i]+x[i-1])*(y[i]-y[i-1]));
			}
			area =(int)sum/2;
			System.out.printf("Plygon area = %.2f cm^2", area);
		}
		catch (InputMismatchException e) {
			System.out.println("Errror: Invalid input");
		}
	}

}
