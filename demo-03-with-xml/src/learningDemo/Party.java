package learningDemo;

public class Party {
	private Cake theCake;
	
	Party(){
		
	}
	
	Party(Cake otherCake){
		System.out.println(">>>Party Constructor Invoked");
		theCake = otherCake;
	}
	
	public void setTheCake(Cake theCake) {
		this.theCake = theCake;
	}

	public void getPartyCakes() {
		System.out.println("Party Started");
		System.out.println(theCake.cakeDetails());
		System.out.println("Cake Name : "+((BDayCake)theCake).getName());
	}
}
