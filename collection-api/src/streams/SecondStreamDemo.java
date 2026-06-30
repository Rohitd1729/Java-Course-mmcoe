package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SecondStreamDemo {
	public static void main(String[] args) {
		List<String>basket = Arrays.asList("Cherry", "Mango", 
				"Papaya", "Guava", "Banana","Apple","Kiwi","Fig");
		
		System.out.println("\n--------- ORIGINAL LIST ---------");
		basket.forEach(System.out::println);
		
		System.out.println("\n--------- sorted() ---------");
		basket.stream()
			  .sorted()
			  .forEach(System.out::println);	// sorted is intermediate operation
		
		System.out.println("\n--------- map(toUpperCase) ---------");
		basket.stream()
			  .map(s -> s.toUpperCase())
			  .forEach(System.out::println);	// map is intermediate operation
		
		System.out.println("\n--------- filter(contains 'a') ---------");
		basket.stream()
			  .filter(s -> s.contains("a"))
			  .forEach(System.out::println);	// filter is intermediate operation
		
		System.out.println("\n--------- filter(contains 'a') + count() ---------");
		System.out.println(
				basket.stream()
					  .filter(s -> s.contains("a"))
					  .count());	// count is terminal operation
		
		System.out.println("\n--------- Stream.of() + sorted() ---------");
		Stream.of(
				"Jim",
				"Anna",
				"Mat",
				"Sam",
				"Brad",
				"Leo")
			  .sorted()
			  .forEach(System.out::println);	// Stream.of creates stream, sorted is intermediate
	}
}
