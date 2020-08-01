package visitor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModemVisitorTest {
    private ModemVisitor unixModemConfigurator;
    private HayesModem hayesModem;
    private ZoomModem zoomModem;
    private ErnieModem ernieModem;

    @Before
    public void setUp() {
        unixModemConfigurator = new UnixModemConfigurator();
        hayesModem = new HayesModem();
        zoomModem = new ZoomModem();
        ernieModem = new ErnieModem();
    }

    @Test
    public void testHayesForUnix() {
        hayesModem.accept(unixModemConfigurator);
        Assert.assertEquals("&s1=4&D=3", hayesModem.configurationString);
    }

    @Test
    public void testZoomForUnix() {
        zoomModem.accept(unixModemConfigurator);
        Assert.assertEquals(42, zoomModem.configurationValue);
    }

    @Test
    public void testErnieForUnix() {
        ernieModem.accept(unixModemConfigurator);
        Assert.assertEquals("C is too slow", ernieModem.internalPattern);
    }
}
