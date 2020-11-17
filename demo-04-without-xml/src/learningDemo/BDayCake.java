package learningDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BDayCake implements Cake {

	@Value("${cake1.name}")
	private String name;

	@Override
	public String cakeDetails() {
		System.out.println("BDay cake details method");
		System.out.println(getName());
		return "returned BDayCake -> cakeDetails";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
