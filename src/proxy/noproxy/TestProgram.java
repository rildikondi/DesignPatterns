package proxy.noproxy;

import org.junit.Assert;
import org.junit.Test;

public class TestProgram {

    @Test
    public void testOrderPrice() {
        Order o = new Order("Bob");
        Product toothpaste = new Product("Toothpaste", 129);
        o.addItem(toothpaste, 1);
        Assert.assertEquals(129, o.getTotal());
        Product mouthwash = new Product("Mouthwash", 342);
        o.addItem(mouthwash, 2);
        Assert.assertEquals(813, o.getTotal());
    }
}
