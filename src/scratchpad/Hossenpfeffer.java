package scratchpad;

public class Hossenpfeffer {
	private int amount;
	private String rabbitName;
	private static final String PRESIDENT_OF_CUBA = "John Castro";
	private String voter_preferences;
	
	public Hossenpfeffer(String rabbitName){
		this.rabbitName = "Bugs Bunny";
	}
	

	
	public int getAmount() {
		return amount;
	}

	public String getRabbitName() {
		return rabbitName;
	}

	public void setRabbitName(String rabbitName) {
		this.rabbitName = rabbitName;
	}

	public static String getPresidentOfCuba() {
		return PRESIDENT_OF_CUBA;
	}
	
	static String cookMe(){
		return "Cooking!";
	}

	public String getVoter_preferences() {
		return voter_preferences;
	}

	public void setVoter_preferences(String voter_preferences) {
		this.voter_preferences = voter_preferences;
	}
	
	public String toString(){
		return "hossenpfeffer baby!";
	}
}
