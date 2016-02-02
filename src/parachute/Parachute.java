package parachute;

import java.util.Random;

public class Parachute {
	//fields: size, style, color
	private int size;
	private int style;
	private int color;
	private double cost;
	private String prefix;
	private String[] colors = {"Yellow", "Red", "Chartreuse"};
	private String[] sizes = {"Small", "Large"};
	private String[] styles = {"Basic", "Deluxe"};
	
	//sizes
	public static final int SMALL = 0;
	public static final int LARGE = 1;
	
	//styles
	public static final int BASIC = 0;
	public static final int DELUXE = 1;
	
	//colors
	public static final int YELLOW = 0;
	public static final int RED = 1;
	public static final int CHARTREUSE = 2;
		
	//Constructor
	public Parachute(int size, int style, int color){
		this.size = size;
		this.style = style;
		this.color = color;
		setCost(calculateCost());
	}

	//methods: open, release, calculateCost, toString
	public double calculateCost(){
		double cost = 0;
		if(size == SMALL && style == BASIC)  cost = 2335;	
		else if (size == LARGE && style == BASIC)  cost = 3279;	
		else if (size == SMALL && style == DELUXE) cost = 4221;
		else if (size == LARGE && style == DELUXE) cost = 5799;	
		return cost;
	}
	
	public String makePreamble(){
		return prefix = String.format("%s %s %s Parachute: ", sizes[size], styles[style], colors[color]);
	}
	
	public String toString(){
		String s = String.format("$%.2f", cost);
		return makePreamble() + s;
	}
		
	public String open(){
		Random r = new Random();
		int luck = r.nextInt(10);
		
		if(luck < 8) return "Parachute opened.";
		else return "Parachute malfunctioned!";
	}
	
	public String release(){
		return "Parachute detached.";
	}
	
	//getters and setters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
		cost = calculateCost();
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
		cost = calculateCost();
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
