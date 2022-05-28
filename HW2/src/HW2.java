import java.io.*;
import java.util.*;

public class HW2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		String input;
		System.out.println("Insert file name: "); 
		FileInputStream reader1, reader2;
		int size = 0, indexOfMax = 0, indexOfMin = 0;
		do{
			try {

				input = scanner.next();
				reader1 = new FileInputStream(input);
				reader2 = new FileInputStream(input);
				break;
			}
			catch(IOException  e)
			{
				System.out.println("Sorry, the file couldn't be opened, please reinsert the file name: ");
				continue;
			}		catch(IllegalArgumentException r)
			{
				System.out.println("Error: "+r);
			}
		}while(true);
		scanner.close();
		Scanner filelines = new Scanner(reader1);
		int CurrentYear = 2020;
		while(filelines.hasNextLine())
		{
			filelines.useDelimiter("");
			filelines.nextLine();
			size++;
		}
		filelines.close();
		Scanner filereader = new Scanner(reader2);
		int[] ID = new int[size];
		String[] Name = new String[size];
		String[] FName = new String[size];
		int[] StartWorking = new int[size];
		int[] BasicSalary = new int[size];
		int[] Award = new int[size];
		int i=0;
		while (filereader.hasNextLine())
		{
			ID[i]=filereader.nextInt();
			Name[i]=filereader.next();
			FName[i]=filereader.next();
			StartWorking[i]=filereader.nextInt();
			BasicSalary[i]=filereader.nextInt();
			i++;
		}
		Award = ComputeAward(size, CurrentYear,  StartWorking, BasicSalary);
		int maximum = ComputeAward(size, Award);
		int minimum = ComputeAward(Award, size);
		for (i = 0; i < size; i++) {
			if ( maximum == Award[i] )
			{
				indexOfMax = i;
			}
			else if (minimum == Award[i])
			{
				indexOfMin = i;
			}
			else
			{
				continue;
			}
		}
		printAwards(ID, Name, FName, Award, maximum, minimum, size, indexOfMax, indexOfMin);
		filereader.close();
	}

public static int[] ComputeAward(int size,int CurrentYear,int  StartWorking[],int BasicSalary[]) {
	int[] Award= new int[size];
	int i;
	int service_period[] = new int[size];
	for (i=0; i<size ; i++) {
		service_period[i] = CurrentYear - StartWorking[i];
		Award[i] = (int)(service_period[i] * 0.20 * BasicSalary[i]);
	}return Award;
}
public static int ComputeAward(int size, int[] Award) { 
	int maximum = Award[0];
	for (int i = 0; i < size; i++) 
	{
		if (Award[i] > maximum)
			maximum = Award[i];
	}
	return maximum;
}
public static int ComputeAward(int[] Award, int size) {
	int minimum = Award[0];
	for (int i = 0; i < size; i++) 
	{
		if (Award[i] < minimum)
			minimum = Award[i];
	}
	return minimum;	
}
public static void printAwards(int[] ID, String[] Name, String[] FName, int[] Award, int maximum, int minimum, int size, int indexOfMax, int indexOfMin) {
	System.out.println("Employ ID	Name			Award");
	for (int i = 0; i < size; i++) {
		System.out.printf("%d	%s %s			%,d%n", ID[i], Name[i], FName[i], Award[i]);
	}
	System.out.printf("---------------------------------------------------------- %n");
	System.out.printf("Highest end service award is [%,d] of [Mr. %s %s]%n", maximum, Name[indexOfMax], FName[indexOfMax]);
	System.out.printf("Lowest end servive award is [%,d] of [Mr. %s %s]", minimum, Name[indexOfMin], FName[indexOfMin]);
}
}

