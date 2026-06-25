
public class Demo2 <T,P>extends Demo1<T>{
	private P temp ;
	
	public Demo2 (T data, P temp ) {
		super(data);
		this.temp = temp;
		
	}

	public P getTemp() {
		return temp;
	}

	public void setTemp(P temp) {
		this.temp = temp;
	}
	public static void main(String[] args) {
		Demo2<String , Integer> sd = new Demo2<String,Integer>("Mona",99);
		System.out.println(sd.getData()+ "\t"+ sd.getTemp());
		
	}
}
