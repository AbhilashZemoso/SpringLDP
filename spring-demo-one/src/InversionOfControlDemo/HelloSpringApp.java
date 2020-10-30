package InversionOfControlDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load spring config
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("appilicationContext.xml"); 
		
		//retrive bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();
	}
	
}
