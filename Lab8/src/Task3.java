import java.util.*;
public class Task3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner kb = new Scanner(System.in);
			int size,i=0,element,index=0;
			boolean found=false;
			System.out.println("Enter the array size: ");
			size = kb.nextInt();
			System.out.print("\nThe array is initialized with the values: ");
			int[] arr = new int[size];
			for (i=0; i<arr.length;i++) {
				arr[i]= (int)(Math.random()*30)+1;
				System.out.print(arr[i]+" ");
			}
			System.out.println("\nEnter the value to search for: ");
			element = kb.nextInt();
			for (i=0; i<arr.length;i++) {
				if (element == arr[i]) {
					found =true;
					index = i;
					break;
				}else {
					continue;
				}
			}
			if (found == true) {
				System.out.printf("The value %d is present in the array, its fist index is %d",element,index);
			}else {
				System.out.printf("The value %d is not present in the array",element);
			}
			
		}
		catch (InputMismatchException e) {
			System.out.println("Errror: Invalid input");
		}
	}

}
