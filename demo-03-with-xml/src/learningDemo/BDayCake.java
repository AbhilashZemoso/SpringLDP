package learningDemo;

public class BDayCake implements Cake {

	private String name;

	@Override
	public String cakeDetails() {
		System.out.println("BDay cake details method");
		return "returned BDayCake -> cakeDetails";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
