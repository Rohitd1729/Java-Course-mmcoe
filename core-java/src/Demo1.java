
public class Demo1<T> {
	private T data;

	public Demo1(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		Demo1<String> d1 = new Demo1<String> ("Hola");
		System.out.println(d1.getData());
		
//		Demo1 d2 = new Demo1 (3.14);
//		System.out.println(d2.getData());
		
//		Demo1 d3 = new Demo1 (new Person ("Kim",22));
//		System.out.println(d3.getData());
		
		
	}
}

