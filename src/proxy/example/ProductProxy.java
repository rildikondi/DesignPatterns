package proxy.example;

public class ProductProxy implements Product {
    private String sku;

    public ProductProxy(String sku) {
        this.sku = sku;
    }

    @Override
    public int getPrice() throws Exception {
        ProductData pd = Db.getProductData(sku);
        return pd.getPrice();
    }

    @Override
    public String getName() throws Exception {
        ProductData pd = Db.getProductData(sku);
        return pd.getName();
    }

    @Override
    public String getSku() {
        return sku;
    }
}
