package proxy.example;

public class ProductImpl implements Product {
    private int price;
    private String name;
    private String sku;

    public ProductImpl(int price, String name, String sku) {
        this.price = price;
        this.name = name;
        this.sku = sku;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSku() {
        return sku;
    }
}
