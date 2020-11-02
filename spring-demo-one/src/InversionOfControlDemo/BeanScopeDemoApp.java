package InversionOfControlDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-appilicationContext.xml");

		Coach theCoach = context.getBean("myCoach",Coach.class);

		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		boolean result = (theCoach==alphaCoach);
		
		System.out.println("Pointing same object: "+result);
		
		System.out.println("Memory Locations \n1: "+theCoach+"\n2: "+alphaCoach);
		
		context.close();
	}

}
