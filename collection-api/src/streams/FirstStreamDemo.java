package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstStreamDemo {

	public static void print(Object obj) {
		System.out.println(obj);
		
	}
	public static int add(int a , int b) {
		return a+b;
		
				
	}
	public static void main(String[] args) {
		Integer[] ar = {2,5,7,6,9,3,2,4};
		List<Integer> numbers = Arrays.asList(ar);
		
		
//		for (Integer n : numbers) 
//			System.out.println(n);
//		
		System.out.println("\n--------- USING forEach() ---------");
		numbers.forEach(System.out::println);

		System.out.println("\n--------- USING METHOD REFERENCE ---------");
		Consumer<Object> c = FirstStreamDemo::print;
		numbers.forEach(c);

		System.out.println("\n--------- USING STREAM + forEach() ---------");
		Stream<Integer> str1 = numbers.stream();
		str1.forEach(System.out::println);	// forEach is the terminal operation

		// System.out.println(str1.count());	
		// count is the terminal operation
		// ERROR: stream already consumed by forEach()

		System.out.println("\n--------- USING distinct() ---------");
		numbers.stream()
		       .distinct()
		       .forEach(System.out::println);	// distinct is intermediate operation

		System.out.println("\n--------- USING distinct() + count() ---------");
		System.out.println(
		        numbers.stream()
		               .distinct()
		               .count());	// count is terminal operation

		System.out.println("\n--------- USING filter(n > 5) + count() ---------");
		System.out.println(
		        numbers.stream()
		               .filter(n -> n > 5)
		               .count());	// filter is intermediate operation

		System.out.println("\n--------- USING distinct() + sorted() ---------");
		numbers.stream()
		       .distinct()
		       .sorted()
		       .forEach(System.out::println);	// sorted is intermediate operation

		System.out.println("\n--------- USING reduce() WITH LAMBDA ---------");
		System.out.println(
		        numbers.stream()
		               .reduce(0, (n, m) -> n + m));	// reduce is terminal operation

		System.out.println("\n--------- USING reduce() WITH Integer::sum ---------");
		System.out.println(
		        numbers.stream()
		               .reduce(0, Integer::sum));	// reduce is terminal operation

		System.out.println("\n--------- USING reduce() WITH add() METHOD ---------");
		System.out.println(
		        numbers.stream()
		               .reduce(0, FirstStreamDemo::add));	// reduce is terminal operation

		System.out.println("\n--------- USING limit(5) ---------");
		numbers.stream()
		       .limit(5)
		       .forEach(System.out::println);	// limit is intermediate operation
		
		
		
		System.out.println("\n--------- count() ---------");
		System.out.println(
		        IntStream.range(1,99).count());

		System.out.println("\n--------- sum() ---------");
		System.out.println(
		        IntStream.range(1,99).sum());

		System.out.println("\n--------- skip(50).sum() ---------");
		System.out.println(
		        IntStream.range(1,99)
		                 .skip(50)
		                 .sum());

		IntStream istr2 =
		        IntStream.of(5,7,6,9,3,2,4);

		System.out.println("\n--------- istr2.count() ---------");
		System.out.println(istr2.count());

		System.out.println("\n--------- summaryStatistics() ---------");

		IntSummaryStatistics statistics =
		        IntStream.of(5,7,6,9,3,2,4)
		                 .summaryStatistics();

		System.out.println(statistics);
		
		
		
		
		
		
		
	}
	
}
