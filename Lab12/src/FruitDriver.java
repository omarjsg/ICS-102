import java.util.*;
public class FruitDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Fruit[] fruit = new Fruit [10]; 
		fruit[0]= new Fruit("banana", 4.0);
		fruit[1]= new Fruit("apple", 5.5);
		fruit[2]= new Fruit("mango", 12.5);
		fruit[3]= new Fruit("orange", 6.0);
		fruit[4]= new Fruit("pineapple", 10.0);
		fruit[5]= new Fruit("pear", 8.6);
		fruit[6]= new Fruit("grapes", 6.5);
		fruit[7]= new Fruit("tangerine", 5.5);
		fruit[8]= new Fruit("watermelon", 8.0);
		fruit[9]= new Fruit("sweetmelon", 7.5);
		Fruit f = new Fruit();
		f.printMenu(fruit);
		Fruit targetFruit = new Fruit();
		System.out.println("\nEnter the fruit that you want to search for: ");
		String search = new String(input.next());
		targetFruit.setName(search);
		if(findFruit(targetFruit, fruit))
		{
			System.out.printf("The fruit \" %s \" that you have selected is available", search);
		}
		else
		{
			System.out.printf("The fruit \" %s \" that you have selected is not available", search);
		}

	}
	public static boolean findFruit(Fruit targetFruit, Fruit[] fruitArray) {
		boolean found = false;
		for (int i = 0; i<fruitArray.length;i++ )
		{
			if(fruitArray[i].getName().equals(targetFruit.getName()))
				found = true;
		
		}
		return found;
	}
}


