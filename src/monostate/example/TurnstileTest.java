package monostate.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstileTest {

    @Before
    public void setUp() {
        Turnstile t = new Turnstile();
        t.reset();
    }

    @Test
    public void testInit() {
        Turnstile t = new Turnstile();
        Assert.assertTrue(t.locked());
        Assert.assertFalse(t.alarm());
    }

    @Test
    public void testCoin() {
        Turnstile t = new Turnstile();
        t.coin();
        Turnstile t1 = new Turnstile();
        Assert.assertFalse(t1.locked());
        Assert.assertFalse(t1.alarm());
        Assert.assertEquals(1, t1.getCoins());
    }

    @Test
    public void testCoinAndPass() {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        Turnstile t1 = new Turnstile();
        Assert.assertTrue(t1.locked());
        Assert.assertFalse(t1.alarm());
        Assert.assertEquals("coins", 1, t1.getCoins());
    }

    @Test
    public void testTwoCoins() {
        Turnstile t = new Turnstile();
        t.coin();
        t.coin();
        Turnstile t1 = new Turnstile();
        Assert.assertFalse("unlocked", t1.locked());
        Assert.assertEquals("coins", 1, t1.getCoins());
        Assert.assertEquals("refunds", 1, t1.getRefunds());
        Assert.assertFalse(t1.alarm());
    }

    @Test
    public void testPass() {
        Turnstile t = new Turnstile();
        t.pass();
        Turnstile t1 = new Turnstile();
        Assert.assertTrue("alarm", t1.alarm());
        Assert.assertTrue("locked", t1.locked());
    }

    @Test
    public void testCancelAlarm() {
        Turnstile t = new Turnstile();
        t.pass();
        t.coin();
        Turnstile t1 = new Turnstile();
        Assert.assertFalse("alarm", t1.alarm());
        Assert.assertFalse("locked", t1.locked());
        Assert.assertEquals("coin", 1, t1.getCoins());
        Assert.assertEquals("refund", 0, t1.getRefunds());
    }

    @Test
    public void testTwoOperations() {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        t.coin();
        Assert.assertFalse("unlocked", t.locked());
        Assert.assertEquals("coins", 2, t.getCoins());
        t.pass();
        Assert.assertTrue("locked", t.locked());
    }
}
