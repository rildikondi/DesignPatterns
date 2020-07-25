package proxy.noproxy;

public class Item {
    private Product product;
    private int quantity;

    public Item(Product p, int qty) {
        product = p;
        quantity = qty;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
