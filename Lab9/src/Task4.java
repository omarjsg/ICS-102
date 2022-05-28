import java.util.*;
public class Task4 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int size = 0;
		do {
			try{
				System.out.println("Enter the array size: ");
				size = kb.nextInt();
				if(size <= 0)
				{
					System.out.println("Error: The array size is <=0");
					continue;
				}
				else
				{
					break;
				}

			}
			catch(InputMismatchException e) 
			{
				System.out.println("Error"+e);
			}
		}while (true);
		double[] array =new double[size];
		System.out.printf("Enter %d values: ", size);
		int index; 
		for(index = 0; index < size; index++)
		{
				array [index] = kb.nextDouble();				
		}
	double[] reversedarray = reverseArray(array,size);
	printArray(reversedarray,size);
	}

	private static double[]reverseArray(double[] array, int size)
	{
		double[] reversedarray = new double[size];
		int index = 0;
		int index_reverse;
		for (index = 0; index<size; index++)
		{
			index_reverse = (size - (index+1));
			reversedarray[index]= array[index_reverse];
		}
		System.out.println();
		return reversedarray;
	}
	private static void printArray(double[] reveresedarray, int size)
	{
		double[] printarray = new double[size];
		int index;
		System.out.print("The reversed array is printed: ");
		for (index = 0; index<size; index++)
		{
			printarray[index]= reveresedarray[index];
			System.out.print(printarray[index]+"\t");
		}
	}
}
