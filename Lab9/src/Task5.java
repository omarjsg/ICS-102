import java.util.*;
public class Task5 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int size = 10;
		int[] x = new int[size];
		try{
			System.out.println("Enter 10 integer values: ");
			for (int index = 0; index < size; index ++)
			{
				x[index] = kb.nextInt();
			}
			System.out.println("Enter an integer value: ");
			int v = kb.nextInt();
			int[] LargerElementsarray = largerElements(x, v, size);
			if (LargerElementsarray.length == 1)
			{
				System.out.printf("The array element larger than %d is: %d", v, LargerElementsarray[0]);
			}
			else if (LargerElementsarray.length > 1)
			{
				System.out.printf("The array element larger than %d is: ", v);
				for (int index = 0; index < LargerElementsarray.length; index++)
				{
					System.out.print(LargerElementsarray[index]+" ");
				}
			}
			else
			{
				System.out.printf("There are no array element larger than %d ", v);
			}
		}
		catch(InputMismatchException e) 
		{
			System.out.println("Error" + e);
		}
	}
	public static int[] largerElements(int[] x, int v, int size)
	{
		int largerElementsize=0, largerElementindex=0, index =0;
		for(index = 0; index < size; index++)
		{
			if (x[index] > v)
			{
				largerElementsize++;
			}
			else
			{
				continue;
			}
		}
		int[] LargerElements = new int[largerElementsize];
		for(index = 0; index < size; index++)
		{
			if (x[index] > v)
			{
				LargerElements[largerElementindex] = x[index];
				largerElementindex++;
			}
			else
			{
				continue;
			}
		}return LargerElements;
	}
}



