package InversionOfControlDemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	//add fields
	private String emailAddress;
	private String team;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public CricketCoach() {	}
	
	@Override
	public String getDailyWorkout() {		
		return "Practice fast bowling";
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
