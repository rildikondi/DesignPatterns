package tabledatagateway;

public interface OrderGateway {
    void insert(Order order);

    Order find(int id);
}
