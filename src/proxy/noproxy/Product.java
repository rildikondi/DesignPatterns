package proxy.noproxy;

public class Product {
    private int price;

    public Product(String name, int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}