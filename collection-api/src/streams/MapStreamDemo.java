package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamDemo {

	public static void main(String[] args) {
		Map<String,String> people = new HashMap<>();
		people.put("Polo","Pune");
		people.put("Ravi","Mumbai");
		people.put("Prashant","Nagpur");

		System.out.println("\n--------- ORIGINAL CITY VALUES ---------");
		people.values().stream().forEach(System.out::println);
		
		
		//--------- map(toUpperCase) + sorted() + collect() ---------");
		
		List<String>cities = people.values().stream().map(c->c.toUpperCase())
				.sorted().collect(Collectors.toList());
		
		System.out.println("\n--------- DISPLAY COLLECTED LIST ---------");
		cities.forEach(System.out::println);
		
		
		Map<String, List<String>> contacts = new HashMap<>();
		contacts.put("Frudo",Arrays.asList("1212-3434","5656-7878"));
		contacts.put("Sean",Arrays.asList("3223-5646","2342-8766","9476-9579"));
		contacts.put("Ben",Arrays.asList("5345-9549","4658-3438","5835-8338"));
		
		System.out.println("\n--------- ORIGINAL CONTACT LISTS ---------");
		contacts.values().forEach(System.out::println);
		
		System.out.println("\n--------- USING flatMap() ---------");

		contacts.values().stream().flatMap(Collection::stream).forEach(System.out::println);	// flatMap is intermediate operation


		System.out.println("\n---------Numbers USING flatMap() + count() ---------");
		System.out.println(contacts.values().stream().flatMap(Collection::stream).count());
		
		System.out.println("\n--------- NUMBERS CONTAINING 8 ---------");
		contacts.values().stream().flatMap(Collection::stream).filter(c->c.contains("8")).forEach(System.out::println);
		
		System.out.println("\n--------- NUMBERS WITHOUT '-'  ---------");
		contacts.values().stream().flatMap(Collection::stream).map(s->s.replace("-","")).forEach(System.out::println);
	}
}
