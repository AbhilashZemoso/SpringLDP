package learningDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("learningDemo")
@PropertySource("classpath:cake.properties")
public class PartyConfig {
	
	@Bean
	public Party startParty() {
		return new Party(getCake());
	}
	
	@Bean
	public Cake getCake() {
		return new BDayCake();
	}

}
