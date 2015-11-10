package bird.shooter;

public class Chicken extends Bird {
	double radius;

	@Override
	public String makeNoise(){
		return "BkBkBkBkaaawh!";
	}
	
	public boolean equals(Object o) 
	{return o instanceof Chicken && radius == ((Chicken)o).radius;}
		 
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}	
}
