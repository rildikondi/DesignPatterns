package proxy.example;

public class ProductData {
    private String name;
    private int price;
    private String sku;

    public ProductData(String name,
                       int price,
                       String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public ProductData() {
    }

    @Override
    public boolean equals(Object o) {
        ProductData pd = (ProductData) o;
        return name.equals(pd.name) &&
                sku.equals(pd.sku) &&
                price == pd.price;
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^
                sku.hashCode() ^
                price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
