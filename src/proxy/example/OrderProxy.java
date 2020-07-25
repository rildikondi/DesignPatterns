package proxy.example;

public class OrderProxy implements Order {
    private int orderId;

    public OrderProxy(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int getTotal() {
        try {
            OrderImp imp = new OrderImp(getCustomerId());
            ItemData[] itemDataArray = Db.getItemsForOrder(orderId);
            for (ItemData item : itemDataArray)
                imp.addItem(new ProductProxy(item.sku), item.qty);
            return imp.getTotal();
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    @Override
    public String getCustomerId() {
        try {
            OrderData od = Db.getOrderData(orderId);
            return od.customerId;
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    @Override
    public void addItem(Product p, int quantity) {
        try {
            ItemData id = new ItemData(orderId, quantity, p.getSku());
            Db.store(id);
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    public int getOrderId() {
        return orderId;
    }
}
