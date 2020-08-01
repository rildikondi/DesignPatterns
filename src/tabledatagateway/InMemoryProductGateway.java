package tabledatagateway;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductGateway implements ProductGateway {
    private static int nextId = 1;
    private Map<Integer, Product> products = new HashMap<>();

    @Override
    public void insert(Product product) {
        products.put(nextId++, product);
    }

    @Override
    public Product find(String sku) {
        for (Product product : products.values())
            if (product.getSku().equals(sku))
                return product;
            return null;
    }
}
