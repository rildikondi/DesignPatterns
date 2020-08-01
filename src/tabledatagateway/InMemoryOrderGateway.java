package tabledatagateway;

import java.util.Hashtable;

public class InMemoryOrderGateway implements OrderGateway {
    private static int nextId = 1;
    private Hashtable<Integer, Order> orders = new Hashtable<>();

    @Override
    public void insert(Order order) {
        orders.put(nextId++, order);
    }

    @Override
    public Order find(int id) {
        return orders.get(id);
    }
}