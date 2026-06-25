import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalDemo {

    // Static method used for Method Reference example
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {

        /* ==========================================================
         * CONSUMER
         * Accepts one input and returns nothing.
         * Abstract Method : accept(T t)
         * ==========================================================
         */

        // Lambda Expression
        Consumer<String> c = (s) -> System.out.println(s);
        // Calls accept("Adios")
        c.accept("Adios");



        // Method Reference to System.out.println()
        // Same as : (s) -> System.out.println(s)
        Consumer<String> c1 = System.out::println;
        c1.accept("Hello");
        c1.accept("Hola");
        c1.accept("Bonjour");



        // Method Reference to our own static method
        // Same as : (s) -> FunctionalDemo.print(s)
        Consumer<String> c2 = FunctionalDemo::print;
        c2.accept("Aloha");



        /* ==========================================================
         * SUPPLIER
         * Takes NO input and returns one value.
         * Abstract Method : get()
         * ==========================================================
         */

        // Always returns "Rohit"
        Supplier<String> s1 = () -> "Rohit";
        // Calls get()
        System.out.println(s1.get());
        // Returned value is passed to print()
        print(s1.get());



        // Supplier that generates a random number
        Supplier<Double> random = () -> Math.random();
        // Every call to get() generates a new random number
        System.out.println(random.get());



        /* ==========================================================
         * PREDICATE
         * Takes one input and returns boolean.
         * Abstract Method : test(T t)
         * ==========================================================
         */

        // Checks whether number is non-negative
        Predicate<Integer> nonNegative = (x) -> x >= 0;
        System.out.println(nonNegative.test(3));   // true
        System.out.println(nonNegative.test(-2));  // false



        // Checks whether number is even
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(5)); // false



        /* ==========================================================
         * BIPREDICATE
         * Takes two inputs and returns boolean.
         * Abstract Method : test(T,U)
         * ==========================================================
         */

        // Checks whether first string contains second string
        BiPredicate<String, String> contains =(str, con) -> str.contains(con);
        System.out.println(contains.test("Mumbai", "u"));



        /* ==========================================================
         * FUNCTION
         * Takes one input and returns one output.
         * Abstract Method : apply(T t)
         * ==========================================================
         */

        // Returns square of a number
        Function<Integer, Integer> square = (x) -> x * x;
        System.out.println(square.apply(5));



        /* ==========================================================
         * BIFUNCTION
         * Takes two inputs and returns one output.
         * Abstract Method : apply(T,U)
         * ==========================================================
         */

        // Returns the greater of two numbers
        BiFunction<Integer, Integer, Integer> greater =(a, b) -> a > b ? a : b;
        System.out.println(greater.apply(10, 20));
    }
}