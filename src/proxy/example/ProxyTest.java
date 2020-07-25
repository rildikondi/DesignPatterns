package proxy.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProxyTest {

    @Before
    public void setUp() throws Exception {
        Db.init();
        ProductData pd = new ProductData();
        pd.setSku("ProxyTest1");
        pd.setName("ProxyTestName1");
        pd.setPrice(456);
        Db.store(pd);
    }

    @After
    public void tearDown() throws Exception {
        Db.deleteProductData("ProxyTest1");
        Db.close();
    }

    @Test
    public void testProductProxy() throws Exception{
        Product p = new ProductProxy("ProxyTest1");
        Assert.assertEquals(456, p.getPrice());
        Assert.assertEquals("ProxyTestName1", p.getName());
        Assert.assertEquals("ProxyTest1", p.getSku());
    }

    @Test
    public void orderProxyTotal() throws Exception {
        Db.store(new ProductData("Wheaties", 349, "wheaties"));
        Db.store(new ProductData("Crest", 258, "crest"));
        ProductProxy wheaties = new ProductProxy("wheaties");
        ProductProxy crest = new ProductProxy("crest");
        OrderData od = Db.newOrder("testOrderProxy");
        OrderProxy order = new OrderProxy(od.orderId);
        order.addItem(crest, 1);
        order.addItem(wheaties, 2);
        Assert.assertEquals(956, order.getTotal());
    }
}