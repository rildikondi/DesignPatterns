package acyclicvisitor.modem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModemVisitorTest {
    private UnixModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private ErnieModem e;

    @Before
    public void SetUp() {
        v = new UnixModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        e = new ErnieModem();
    }

    @Test
    public void HayesForUnix() {
        h.accept(v);
        Assert.assertEquals("&s1=4&D=3", h.configurationString);
    }

    @Test
    public void ZoomForUnix() {
        z.accept(v);
        Assert.assertEquals(42, z.configurationValue);
    }

    @Test
    public void ErnieForUnix() {
        e.accept(v);
        Assert.assertEquals("C is too slow", e.internalPattern);
    }
}