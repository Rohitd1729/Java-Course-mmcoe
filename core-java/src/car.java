
public class car {
	private String model;
	private String[] features;
	//Var-args : Can only be the last argument of the method 
	public car(String model, String... features) {
		super();
		this.model = model;
		this.features = features;
	} 
	public void specs () {
		System.out.println("Feature of "+ model);
		for (String f : features)
			System.out.println(f);
	}
	
	public static void main(String[] args) {
		car Mer = ("Sunroof","ABS","TouchScreen");
				
				
		car c1 =  new car("Mercedes", features);
		c1.specs();
				
	}
	
	
}
