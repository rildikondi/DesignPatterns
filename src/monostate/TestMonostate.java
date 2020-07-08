package monostate;

import org.junit.Assert;
import org.junit.Test;

public class TestMonostate {
    @Test
    public void testInstance() {
        Monostate m = new Monostate();
        for (int x = 0; x < 10; x++) {
            m.setX(x);
            Assert.assertEquals(x, m.getX());
        }
    }

    @Test
    public void testInstancesBehaveAsOne() {
        Monostate m1 = new Monostate();
        Monostate m2 = new Monostate();
        for (int x = 0; x < 10; x++) {
            m1.setX(x);
            Assert.assertEquals(x, m2.getX());
        }
    }
}
