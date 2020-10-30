package InversionOfControlDemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "hard push ups";
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it : "+fortuneService.getFortune();
	}

}
