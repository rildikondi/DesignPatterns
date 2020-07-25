package proxy.example;

import java.util.ArrayList;
import java.util.List;

public class OrderImp implements Order {
    private List<Item> items = new ArrayList<>();
    private String customerId;

    public OrderImp(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public void addItem(Product p, int quantity) {
        Item item = new Item(p, quantity);
        items.add(item);
    }

    @Override
    public int getTotal() {
        try {
            int total = 0;
            for (Item item : items) {
                Product p = item.getProduct();
                int qty = item.getQuantity();
                total += p.getPrice() * qty;
            }
            return total;
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }
}
