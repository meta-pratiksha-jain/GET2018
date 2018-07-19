/*
 * Calculates area of different objects
 */
public class Area {
	
	public Area(){}
	
	private final double PIE=3.14;
	
	/*
	 * Calculates area of triangle
	 * @param base contains base of the triangle
	 * @param height contains height of triangle.Assume base>0 and height>0
	 * @returns area contains area of triangle
	 */
	public double areaTriangle(double base, double height) throws ArithmeticException
	{
		double area=(base*height)/2;
		return area;
	}
	
	public double areaRectangle(double width, double height) throws ArithmeticException
	{
		double area=width*height;
		return area;
	}
	
	public double areaSquare(double side) throws ArithmeticException
	{
		double area=side*side;
		return area;
	}
	
	public double areaCircle(double radius) throws ArithmeticException
	{
		double area=PIE*radius*radius;
		return area;
	}

}
