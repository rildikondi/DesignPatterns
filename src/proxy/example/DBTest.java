package proxy.example;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DBTest {

    @Before
    public void setUp() throws Exception {
        Db.init();
    }

    @After
    public void tearDown() throws Exception {
        Db.clear();
        Db.close();
    }

    @Test
    public void testStoreProduct() throws Exception {
        ProductData storedProduct = new ProductData();
        storedProduct.setName("MyProduct");
        storedProduct.setPrice(1234);
        storedProduct.setSku("999");
        Db.store(storedProduct);
        ProductData retrievedProduct = Db.getProductData("999");
        Db.deleteProductData("999");
        Assert.assertEquals(storedProduct, retrievedProduct);
    }

    @Test
    public void testOrderKeyGeneration() throws Exception {
        OrderData o1 = Db.newOrder("Bob");
        OrderData o2 = Db.newOrder("Bill");
        int firstOrderId = o1.orderId;
        int secondOrderId = o2.orderId;
        Assert.assertEquals(firstOrderId + 1, secondOrderId);
    }

    @Test
    public void testStoreItem() throws Exception {
        ItemData storedItem = new ItemData(1, 3, "sku");
        Db.store(storedItem);
        ItemData[] retrievedItems = Db.getItemsForOrder(1);
        Assert.assertEquals(1, retrievedItems.length);
        Assert.assertEquals(storedItem, retrievedItems[0]);
    }

    @Test
    public void testNoItems() throws Exception {
        ItemData[] id = Db.getItemsForOrder(42);
        Assert.assertEquals(0, id.length);
    }
}