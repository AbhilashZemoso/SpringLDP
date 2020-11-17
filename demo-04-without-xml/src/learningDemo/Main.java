package learningDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(PartyConfig.class);
		
		//Cake cake = context.getBean(Cake.class);
		
		Party party = context.getBean(Party.class);
		
		party.getPartyCakes();
		
		context.close();
		
	}

}
