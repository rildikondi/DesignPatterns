package tabledatagateway;

public interface ProductGateway {
    void insert(Product product);

    Product find(String sku);
}
