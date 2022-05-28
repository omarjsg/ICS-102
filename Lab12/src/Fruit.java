
public class Fruit {
	private String name;
	private double pricePerKilogram = 0;

	public Fruit(String name, double pricePerKilogram) {
		this.name = name;
		this.pricePerKilogram = pricePerKilogram;
	}
	public Fruit() {
		// TODO Auto-generated constructor stub
	}
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Fruit c = (Fruit)obj;
			return this.name == c.name && this.pricePerKilogram == c.pricePerKilogram;
		}
	}
	// to get the price per kilogram
	public double getPricePerKilogram() {
		return this.pricePerKilogram;
		//to get the name
	}
	public String getName() {
		return this.name;
	}
	// to set the name
	public void setName(String name) {
		this.name = name;
	}
	// to set the price
	public void setPricePerKilogram(double pricePerKilogram) {
		this.pricePerKilogram = pricePerKilogram;
	}
	//To display the array
	/*public String toString()
	{
		return String.format("name = %s,  Price per Kilogram %.1f", name, pricePerKilogram);
	}*/
	public void printMenu(Fruit[] fruit) 
	{
		int index =0;
		System.out.println("These are the fruits that are are more than 5.00 SR\n");
		while(index<fruit.length)
		{
			if (fruit[index].getPricePerKilogram()> 5.00)
			{
				System.out.println(fruit[index].toString());
			}
			index++;
		}

	}
}