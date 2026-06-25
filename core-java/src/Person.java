
public class Person implements Cloneable {
	private String name ;
	private int age;
	
	public Person() {
		this("Anonymous", -1);//No need to duplicate all the values * Java call another Constructor on the Same Object , *Constructor Chaining 
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.println("Name: "+ name +", Age: " + age );
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj ;
			if (this.age==p.age && name.equals(p.name))
				return true;
			
		}
		return false;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person ("Polo", 21);
		p1.print();
		Person p2 = new Person ();
		p2.print();
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p1);//Implicitly call tostring() on object 
		
		System.out.println(p1.equals(p2));//compares the hashcode 
		//false
		
		Person pc = (Person) p1.clone();
		System.out.println(pc);
				
		
		
	}
}
