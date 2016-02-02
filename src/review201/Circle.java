package review201;

public class Circle {	
	private double radius; //fields
	private boolean border;
	private static int numberOfCicles = 0;
	
	Circle(double r){
		radius = r;
		numberOfCicles++;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		radius = radius;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	//behaviors
	double calculateArea(){

		double area = Math.PI * radius*radius;
		return area;
	}

	public static int getNumberOfCicles() {
		return numberOfCicles;
	}

	
}
