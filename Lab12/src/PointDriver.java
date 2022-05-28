public class PointDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 100;
		double x = 0, y = 0;
		Point[] point = new Point[6];
		Point distance = new Point();
		point[0]=new Point(0, 0);
		point[1]=new Point(3, 5);
		point[2]=new Point(3, 8);
		point[3]=new Point(4, -1);
		point[4]=new Point(2, -3);
		point[5]=new Point(1, 7);
		//To find the shortest distance.
		double min = d;
		for (int i = 1; i < point.length ; i++)
		{
			d = point[i].distanceFrom(point[0]);
			if (min > d) {
				min = d;
				x = point[i].getX();
				y = point[i].getY();
			}
		}
		System.out.println(toString(x,y,min));		
	}
	//To display the result to the user.
	public static String toString(double x, double y, double min) {
		return String.format("The shortest distance to the origin - (0, 0) from the five points is = %.2f, from the point (%.1f, %.1f)",min,x,y);
	}

}


