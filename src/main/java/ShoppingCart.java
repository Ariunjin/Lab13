import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    String id;
    String userid;
    List<Product> products = new ArrayList<Product>();
    ShoppingCart(String id, String userid){
        this.id = id;
        this.userid = userid;
    }
    public void addProduct(Product prod){
        this.products.add(prod);
    }
    public List<Product> getProducts(){
        return products;
    }
}
