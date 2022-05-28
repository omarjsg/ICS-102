import java.util.*;
public class SphereDriver {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double y = 0, x = 0, r = 0;
		 Sphere sphere1 = null;
		try {
			System.out.println("Enter sphere 1 radius: ");
			r = kb.nextDouble();
			System.out.println("Enter x, y coordinates of sphere 1 center: ");
			x = kb.nextDouble();
			y = kb.nextDouble();
			sphere1 = new Sphere(r,x,y);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e);
			System.exit(1);
		} 
		catch (InputMismatchException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		kb.close();
		System.out.println("Sphere 1 before modification: ");
		System.out.printf("Center ( %.2f , %.2f )", sphere1.getXCenter(), sphere1.getYCenter());
		System.out.printf("%nRadius = %.2f cm", sphere1.getRadius());
		System.out.printf("%nVolume = %.2f cubic cm",sphere1.volume());
		System.out.printf("%nSurface Area = %.2f square cm",sphere1.surfaceArea());
		System.out.println();
		System.out.println();
		sphere1.setRadius(sphere1.getRadius()*2);
		sphere1.setXCenter(sphere1.getXCenter()+3.0);
		sphere1.setYCenter(sphere1.getYCenter()-12.0);
		System.out.println("Sphere 1 after modification: ");
		System.out.printf("Center ( %.2f , %.2f )", sphere1.getXCenter(), sphere1.getYCenter());
		System.out.printf("%nRadius = %.2f cm", sphere1.getRadius());
		System.out.printf("%nVolume = %.2f cubic cm",sphere1.volume());
		System.out.printf("%nSurface Area = %.2f square cm",sphere1.surfaceArea());	
	}
}
class Sphere{
	private double radius, xCenter, yCenter;
	public Sphere(double radius, double xCenter, double yCenter)  throws IllegalArgumentException{
		if (radius<0)
		{
			throw new IllegalArgumentException();
		}
		this.radius = radius;
		this.xCenter = xCenter;
		this.yCenter = yCenter;
	}
	public double volume( ){      		
		return (4/3.0)*Math.PI*Math.pow(radius,3);	
	} 
	public double surfaceArea( ) {	
		return (4)*Math.PI*Math.pow(radius,2);
	}
		public double getRadius() {
			return radius;
		}
		public double setRadius(double radius) throws IllegalArgumentException {
			if (radius<0)
			{
				throw new IllegalArgumentException();
			}
			this.radius = radius;
			return radius;
	}
	public double getXCenter() {
		return xCenter;
	}
	public double setXCenter(double xCenter) {
		this.xCenter = xCenter;
		return xCenter;
	}
	public double getYCenter() {
		return yCenter;
	}
	public double setYCenter(double yCenter) {
		this.yCenter = yCenter;
		return yCenter;
	}
}
