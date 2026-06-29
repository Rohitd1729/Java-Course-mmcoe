import java.util.HashMap;

public class MapDemo {
	public static void main(String[] args) {
		HashMap<String, String>map = new HashMap<>();
		
		map.put("Rohit", "Science");
		map.put("Rahul", "Maths");
		map.put("Avinash", "Geography");
		map.put("Revan", "History");
		
		
		System.out.println("Rohit teach : " + map.get("Rohit"));
		System.out.println("Rahul teach : " + map.get("Rahul"));
		System.out.println("Avinash teach : " + map.get("Avinash"));
		System.out.println("Revan teach : " + map.get("Revan"));
		
		System.out.println("----------------------------");
		//print all the keys and values without manually feeding keys
		for (String key : map.keySet())
			System.out.println(key + ": "+ map.get(key));
		System.out.println("----------------------------");
		map.forEach((key, value)->System.out.println(key + ": " + value));
		
		
		
	}
}
