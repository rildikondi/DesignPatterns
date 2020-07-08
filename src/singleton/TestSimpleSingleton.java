package singleton;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class TestSimpleSingleton {

    @Test
    public void testCreateSingleton() {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Assert.assertSame(s, s2);
    }

    @Test
    public void TestNoPublicConstructors() {
        Class<Singleton> singleton = Singleton.class;
        Constructor[] ctrs = singleton.getDeclaredConstructors();
        boolean hasPublicConstructor = false;
        for (Constructor c : ctrs) {
            if (c.getModifiers() == Modifier.PUBLIC) {
                hasPublicConstructor = true;
                break;
            }
        }
        Assert.assertFalse(hasPublicConstructor);
    }
}