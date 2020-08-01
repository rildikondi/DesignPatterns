package decorator;

import org.junit.Assert;
import org.junit.Test;

public class ModemDecoratorTest {

    @Test
    public void testCreateHayes() {
        Modem m = new HayesModem();
        Assert.assertNull(m.getPhoneNumber());
        m.dial("5551212");
        Assert.assertEquals("5551212", m.getPhoneNumber());
        Assert.assertEquals(0, m.getSpeakerVolume());
        m.setSpeakerVolume(10);
        Assert.assertEquals(10, m.getSpeakerVolume());
    }

    @Test
    public void testLoudDialModem() {
        Modem m = new HayesModem();
        Modem d = new LoudDialModem(m);
        Assert.assertNull(d.getPhoneNumber());
        Assert.assertEquals(0, d.getSpeakerVolume());
        d.dial("5551212");
        Assert.assertEquals("5551212", d.getPhoneNumber());
        Assert.assertEquals(10, d.getSpeakerVolume());
    }
}
