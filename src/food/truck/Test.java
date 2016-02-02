package food.truck;

public class Test {

	public static void main(String[] args) {
		FoodTruck ft = new FoodTruck();
		Chef chef = new Chef();
		GordonRamsey currentChef = (GordonRamsey) chef;
		ft.operate(currentChef);
		


	}

}
