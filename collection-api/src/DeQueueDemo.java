import java.util.Deque;
import java.util.LinkedList;

public class DeQueueDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		
		deque.offerLast("Apple");
		deque.offerLast("Banana");
		
		deque.offerFirst("Cherry");
		
		System.out.println("Deque: " + deque);
		System.out.println("----------------");
		
		
		// Peek operations
		System.out.println("Front Element: " + deque.peekFirst());
		System.out.println("Rear Element: " + deque.peekLast());

		// Remove from front
		System.out.println("Removed Front: " + deque.pollFirst());

		// Remove from rear
		System.out.println("Removed Rear: " + deque.pollLast());

		System.out.println("Remaining Deque: " + deque);

		
	}
}
