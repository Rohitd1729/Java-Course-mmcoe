import com.mmcoe.cart.Product;
import com.mmcoe.cart.Shopping;
import com.mmcoe.cart.CartFactory;
import com.mmcoe.cart.CartException;


public class TestShopping {

    public static void main(String[] args) {

        Shopping cart = CartFactory.newCart();

        try {

            cart.addToCart(new Product("Notebook",80));
            cart.addToCart(new Product("Pencil",10));
            cart.addToCart(new Product("Scale",20));
            cart.addToCart(new Product("Pen",25));
            cart.addToCart(new Product("Marker",60));
            cart.addToCart(new Product("Bag",700));

        }
        catch(CartException e) {

            System.out.println(e.getMessage());

        }

        cart.checkout();

    }

}
