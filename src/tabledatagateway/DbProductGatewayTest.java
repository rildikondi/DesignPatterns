package tabledatagateway;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbProductGatewayTest extends AbstractDbGatewayTest {
    private DbProductGateway gateway;

    @Before
    public void setUp() {
        openConnection();
        gateway = new DbProductGateway(connection);
        executeSql("DELETE FROM Products");
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void testInsert() {
        try {
            Product product = new Product("Peanut Butter", "pb", 3);
            gateway.insert(product);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Products");
            ResultSet resultSet = preparedStatement.executeQuery();
            Assert.assertTrue(resultSet.next());
            Assert.assertEquals("pb", resultSet.getString("sku"));
            Assert.assertEquals("Peanut Butter", resultSet.getString("name"));
            Assert.assertEquals(3, resultSet.getInt("price"));
            Assert.assertFalse(resultSet.next());
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    @Test
    public void testFind() {
        Product pb = new Product("Peanut Butter", "pb", 3);
        Product jam = new Product("Strawberry Jam", "jam", 2);
        gateway.insert(pb);
        gateway.insert(jam);
        Assert.assertNull(gateway.find("bad sku"));
        Product foundPb = gateway.find(pb.getSku());
        checkThatProductsMatch(pb, foundPb);
        Product foundJam = gateway.find(jam.getSku());
        checkThatProductsMatch(jam, foundJam);
    }

    private static void checkThatProductsMatch(Product pb, Product pb2) {
        Assert.assertEquals(pb.getName(), pb2.getName());
        Assert.assertEquals(pb.getSku(), pb2.getSku());
        Assert.assertEquals(pb.getPrice(), pb2.getPrice());
    }
}
