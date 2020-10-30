package InversionOfControlDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load Spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("appilicationContext.xml");
		
		//retrive bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		//call methods
		System.out.println(theCoach.getDailyFortune());
		
		//call new method to get literals
		System.out.println(theCoach.getEmailAddress());;
		
		System.out.println(theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
