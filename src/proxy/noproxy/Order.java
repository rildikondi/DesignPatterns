package proxy.noproxy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();

    public Order(String cusid) {
    }

    public void addItem(Product p, int qty) {
        Item item = new Item(p, qty);
        items.add(item);
    }

    public int getTotal() {
        int total = 0;
        for (Item item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            total += p.getPrice() * qty;
        }
        return total;
    }
}
