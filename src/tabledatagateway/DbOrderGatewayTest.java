package tabledatagateway;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;


public class DbOrderGatewayTest extends AbstractDbGatewayTest {
    private DbOrderGateway gateway;
    private Product pizza;
    private Product beer;

    @Before
    public void setUp() {
        openConnection();
        pizza = new Product("Pizza", "pizza", 15);
        beer = new Product("Beer", "beer", 2);
        ProductGateway productGateway = new InMemoryProductGateway();
        productGateway.insert(pizza);
        productGateway.insert(beer);
        gateway = new DbOrderGateway(connection, productGateway);
        executeSql("DELETE FROM Orders");
        executeSql("DELETE FROM Items");
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void testFind() throws Exception {
        int newMaxOrderId = gateway.getMaxOrderId() + 1;
        String sql = "INSERT INTO Orders (orderId, customerId) VALUES (? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, newMaxOrderId);
        preparedStatement.setString(2, "Snoopy");
        preparedStatement.execute();
        executeSql(String.format("INSERT INTO Items (orderId, " +
                "quantity, sku) VALUES (%d, 1, 'pizza')", newMaxOrderId));
        executeSql(String.format("INSERT INTO Items (orderId, " +
                "quantity, sku) VALUES (%d, 6, 'beer')", newMaxOrderId));
        Order order = gateway.find(newMaxOrderId);
        Assert.assertEquals("Snoopy", order.getCustomerId());
        Assert.assertEquals(2, order.getItemCount());
        Assert.assertEquals(1, order.quantityOf(pizza));
        Assert.assertEquals(6, order.quantityOf(beer));
    }

    @Test
    public void testInsert() {
        Order order = new Order("Snoopy");
        order.addItem(pizza, 1);
        order.addItem(beer, 6);
        gateway.insert(order);
        Assert.assertTrue(order.getOrderId() != -1);
        Order foundOrder = gateway.find(order.getOrderId());
        Assert.assertEquals("Snoopy", foundOrder.getCustomerId());
        Assert.assertEquals(2, foundOrder.getItemCount());
        Assert.assertEquals(1, foundOrder.quantityOf(pizza));
        Assert.assertEquals(6, foundOrder.quantityOf(beer));
    }
}
