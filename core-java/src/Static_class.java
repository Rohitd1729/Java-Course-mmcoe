// Static members are class members.
// They belong to the class, not to individual objects.
// Only one copy of a static member exists.
// They are shared by all objects of the class.
// They can be accessed without creating an object.
// They are inherited by subclasses but cannot be overridden.
// They should be accessed using the class name.
          /*
             Count 
               2 
             /    \
            /      \
          data     data
          100       200
*/

class Demo{
	private int data;
	private static  int count;
	
	public Demo (int data) {
		this.data = data;
		count++;
	}
	void main(){
		Demo d1 = new Demo (100);
		Demo d2 = new Demo (200);
	}
}

//A final class in Java is a class that cannot be extended (inherited).
//A final class is a class that cannot be subclassed.
//A final class cannot be inherited.
//It can have constructors.
//It can have instance and static members.
//It can contain final and non-final methods.
//Objects of a final class can be created.
//It cannot be declared abstract.
