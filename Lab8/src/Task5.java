import java.util.*;
public class Task5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner kb = new Scanner(System.in);
			int size,i=0;
			double x1=Double.MIN_VALUE,element;
			boolean decreasing=false,invalid = true;
			do{
				System.out.println("Enter the array size: ");
				size = kb.nextInt();
				if(size >0) {
					invalid = false;
				}else {
					System.out.println("Error: please enter a positie value for the size. ");
					continue;
				}
			} while(invalid);

			double[] arr = new double[size];
			for (i=0; i < size; i++)
			{
				System.out.printf("Enter element at index# %d of the array: ", i);
				element = kb.nextDouble();
				arr[i]= element;
			}
			for (i=1; i < size; i++)
			{
				if(arr[i]>=arr[i-1]) {
					continue;
				}else {
					decreasing = true;
				}
			}
			if (decreasing) {
				System.out.println("The array is not sorted in non-decreasing order");
			}else {
				System.out.println("The array is sorted in non-decreasing order");
			}

		}
		catch (InputMismatchException e) {
			System.out.println("Errror: Invalid input");
		}
	}

}
