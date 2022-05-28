public class Task4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] food = new String[5];
		String newWord = "";
		food[0] = "Hot Peppers";
		food[1] = "Onions";
		food[2] = "Milk";
		food[3] = "Eggs";
		food[4] = "Rice";
		for(int i = 0; i < food.length; i++)
		{
			char ch = food[i].charAt(0);
			newWord+=ch;
		}
		System.out.println(newWord);
	}
}
