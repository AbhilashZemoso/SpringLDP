package learningDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		Party theParty = context.getBean("myParty",Party.class);
		
		theParty.getPartyCakes();
		
	}

}
