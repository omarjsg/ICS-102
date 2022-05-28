import java.util.*;
public class Task2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner kb = new Scanner(System.in);
			int size,i=0,maxindex=0,minindex=0;
			double element,max=0,min=0;
			System.out.println("Enter the array size: ");
			size = kb.nextInt();
			double[] arr = new double[size];
			for(i=0;i<arr.length;i++) {
				System.out.printf("Enter element at index# %d of the array: ", i);
				element = kb.nextDouble();
				arr[i] = element;
				if (arr[i]>max) {
					max = element;
					maxindex = i;
				}else if (arr[i]<min) {
					min = element;
					minindex = i;
				}else {
					element = element;
				}
				
			}
			System.out.printf("Max value = %.2f, its first occurence is at index# %d ", max, maxindex);
			System.out.printf("%nMin value = %.2f, its first occurence is at index# %d ", min, minindex);
		}
		catch (InputMismatchException e) {
			System.out.println("Errror: Invalid input");
		}

	

	}

}
