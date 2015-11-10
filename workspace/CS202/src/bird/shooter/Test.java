package bird.shooter;

public class Test {

	public static void main(String[] args) {
		BirdShooter bs = new BirdShooter();
		Duck donald = (Duck)new Bird();
		Bird foghornLeghorn = new Chicken();
		
		bs.shootBird(donald);
		bs.shootBird(foghornLeghorn);

	}

}
