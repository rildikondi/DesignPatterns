package facade;

public class Application {

    private ProductData productData;

    public void saveProduct(ProductData productData) {
        Db.store(productData);
    }
}
