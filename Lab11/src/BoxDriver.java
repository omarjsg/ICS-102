import java.util.Scanner;
import java.util.InputMismatchException;
 class Box
{
	private double length , width , height;

	Box(double boxLength , double boxWidth , double boxHeight) throws IllegalArgumentException
	{
		if(boxLength <= 0 || boxWidth <= 0 || boxHeight <= 0)
			throw new IllegalArgumentException("Error: Dimension <= 0");

		length = boxLength;
		width = boxWidth;
		height = boxHeight;
	}
	// Add copy constructor
	Box(Box copy){
		length = copy.length;
		width = copy.width;
		height = copy.height;
	}
	public double volume()
	{
		return length * width * height;
	}

	public double surfaceArea()
	{
		return 2*(length*width + length*height + width*height);
	}
	// Add a toString method
	public String toString() {
		return String.format("Length = %.1f cm, Width = %.1f cm, Height = %.1f cm", this.length, this.width, this.height);
	}
	// Add an equals method
	  public boolean equals(Box obj){
	       if(obj == null)
	          return false;
	       else if(getClass() != obj.getClass())
	          return false;
	       else{
	          Box  b = (Box) obj;
	          return this.length == b.length && this.width == b.width && this.height == b.height;
	       }
	  }
	// Add accessor or get methods (Previous Lab10 Task)
	   	public double getLength() {
	   		return length;
	   		}
	   	public double getWdth() {
	   		return length;
	   		}
	   	public double getHeight() {
	   		return height;
	   		}
	// Add mutator or set methods that throw IllegalArgument exception if arguments are not valid (Previous lab task)
		public void setLength(double length) throws IllegalArgumentException{ 
			if(length <= 0)
				throw new IllegalArgumentException("Error: Dimension <= 0");		
			this.length = length;
	}
		public void setWidth(double width) throws IllegalArgumentException{ 
			if(width <= 0)
				throw new IllegalArgumentException("Error: Dimension <= 0");		
			this.width = width;	
	}
		public void setHeight(double height) throws IllegalArgumentException{ 
			if(height <= 0)
				throw new IllegalArgumentException("Error: Dimension <= 0");		
			this.height = height;	
	}
}

public class BoxDriver
{
	public static void main(String[] args)
	{
		Scanner kbscanner = new Scanner(System.in);
		double length, width, height;
		// Create two Box objects
		Box box1 = null, box2 = null;
		double volume, area;
		try {
		// Get and display volume and surface area of box1
		System.out.println("Enter the length, width, height of box1 [in cm] : ");
		length = kbscanner.nextDouble();
		width =  kbscanner.nextDouble();
		height =  kbscanner.nextDouble();
		box1 = new Box(length,width,height);
		System.out.println("Enter the length, width, height of box2 [in cm] : ");
		length = kbscanner.nextDouble();
		width =  kbscanner.nextDouble();
		height =  kbscanner.nextDouble();
		box2 = new Box(length,width,height);
		volume = box1.volume();
		area = box1.surfaceArea();
		System.out.printf("The volume of box1 is %.1f  cubic cm%n", volume);
		System.out.printf("The surface area of box1 is %.1f square cm%n", area);
		// Get and display volume of surface area box2
		volume = box2.volume();
		area = box2.surfaceArea();
		System.out.printf("The volume of box2 is %.1f  cubic cm%n", volume);
		System.out.printf("The surface area of box2 is %.1f square cm%n", area);
		// Write code to print each of the box objects using its toString method
		System.out.println("Box1: " + box1.toString());
		System.out.println("Box2: " + box2.toString());
		// Write code to compare box1 and box2 using the equals method; display the result
		//of the comparison by an appropriate message
		if (box1.equals(box2))
		{
			System.out.println("The two boxes are equal");
		}
		else
		{
			System.out.println("The two boxes are not equal");
		}
        // Create box3 as a copy of box1 using the copy constructor of Box class
		Box box3 = new Box(box1);
        // then display it using its toString method
		System.out.println("Box3: " + box3.toString());
		}
		catch(InputMismatchException e )
		{
			System.out.println(e);
			System.exit(1);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
}
