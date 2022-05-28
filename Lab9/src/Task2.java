import java.util.*;
import java.io.*;
public class Task2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the volume [cm3] and hight [cm] of a cone: ");

		try {
			double volume = kb.nextDouble();
			double hight = kb.nextDouble();	
			double sa = getSurfaceArea(hight,  getRadius(volume, hight));
			System.out.printf("Surface area = %.2f squar cm", sa);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Error: "+e);
		}
		catch(IllegalArgumentException r)
		{
			System.out.println("Error: "+r);
		}
	}
	public static double getRadius(double v, double h )throws IllegalArgumentException{
		if ( v <= 0 || h <= 0 )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			double radius = Math.sqrt((3*v)/(Math.PI*h));
			return radius;	
		}

	} 
	public static double getSurfaceArea(double h,double r )throws IllegalArgumentException{
		if (r <0 )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			double SurfaceArea = (Math.PI*r*Math.hypot(h, r)+Math.PI*Math.pow(r,2));
			return SurfaceArea;	
		}
	}
}
