
public class TestEmployee {

	public static void main(String[] args) {
		Manager m = new  Manager (1500,800);
		
		Clerk c = new  Clerk (1200, 400);
		
		
	
		
		showSalary(m);
		showSalary(c);
		//showSalary(e);
	}

//	private static void showSalary(Manager m) {
//		System.out.println("Manager Salary "+ m.getSalary());
//	}	
//		private static void showSalary(Clerk c) {
//			System.out.println("Clerk Salary "+ c.getSalary());
//			
//	}
		private static void showSalary(Employee e) {
			if (e instanceof Manager)
				System.out.println("Manager Salary "+ e.getSalary());
			else
				System.out.println("Clerk Salary "+ e.getSalary());
		}
		
}
