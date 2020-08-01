package tabledatagateway;

public class Product {
    private  String name;
    private  String sku;
    private int price;

    public Product() {
    }

    public Product(String name, String sku, int price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}