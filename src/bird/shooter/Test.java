package bird.shooter;

public class Test {

	public static void main(String[] args) {
//		BirdShooter bs = new BirdShooter();
//		Duck donald = (Duck)new Bird();
//		Bird foghornLeghorn = new Chicken();
//		
//		bs.shootBird(donald);
//		bs.shootBird(foghornLeghorn);
		
		Chicken foghornLeghorn = new Chicken();
		foghornLeghorn.setRadius(30);
		Chicken fg = new Chicken();
		fg.setRadius(30);
		
		System.out.println(fg.equals(foghornLeghorn));
		System.out.println(fg);
		System.out.println(foghornLeghorn);

	}

}
