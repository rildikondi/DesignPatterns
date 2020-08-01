package tabledatagateway;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String customerId;
    private List<Item> items = new ArrayList<>();
    private int orderId;

    public Order(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemCount() {
        return items.size();
    }

    public int quantityOf(Product product) {
        for(Item item : items)
        {
            if (item.getProduct().getSku().equals(product.getSku()))
                return item.getQuantity();
        }
        return 0;
    }

    public void addItem(Product p, int qty) {
        Item item = new Item(p, qty);
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public int getTotal() {
        int total = 0;
        for(Item item : items)
        {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            total += p.getPrice() * qty;
        }
        return total;
    }
}