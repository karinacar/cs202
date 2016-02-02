package parachute;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Parachute[] parachutes = new Parachute[200];
		Random r = new Random();
		
		for(int i = 0; i<200; i++){
			parachutes[i] = new Parachute(
					r.nextInt(2),
					r.nextInt(2),
					r.nextInt(3));
			
		}
		double cost = 0;
		for(int i = 0; i<200; i++){
			cost += parachutes[i].getCost();
			System.out.println(parachutes[i]);
		}
		System.out.printf("You owe: $%.2f", cost);


	}

}
