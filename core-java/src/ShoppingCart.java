
public class ShoppingCart {
	private Product[] items;
	private double total;
	private int count ;
	
	
	public ShoppingCart() {
		items = new Product[5];
		count = 0;
		total = 0;
		
	}
	public void addToCart (Product p) {
		if (count == items.length)
			System.out.println("Your cart is full");
		else {
			items[count++]= p;
			total +=p.getPrice();
		}
	}
	public void checkout () {
		for (int i=0;i<count;i++)
			System.out.println(items[i]);
		System.out.println("Cart Total : "+ total);
	}
}
