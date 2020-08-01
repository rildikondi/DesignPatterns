package extensionobject;

import org.jdom.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class BomXmlTest {
    private PiecePart piecePart1;
    private PiecePart piecePart2;
    private Assembly assembly;

    @Before
    public void setUp() {
        piecePart1 = new PiecePart("997624", "MyPart", 3.20);
        piecePart2 = new PiecePart("7734", "Hell", 666);
        assembly = new Assembly("5879", "MyAssembly");
    }

    @Test
    public void testCreatePart() {
        Assert.assertEquals("997624", piecePart1.getPartNumber());
        Assert.assertEquals("MyPart", piecePart1.getDescription());
        Assert.assertEquals(3.20, piecePart1.getCost(), .01);
    }

    @Test
    public void testCreateAssembly() {
        Assert.assertEquals("5879", assembly.getPartNumber());
        Assert.assertEquals("MyAssembly", assembly.getDescription());
    }

    @Test
    public void testAssembly() {
        assembly.add(piecePart1);
        assembly.add(piecePart2);
        Assert.assertEquals(2, assembly.getParts().size());
        Assert.assertEquals(assembly.getParts().get(0), piecePart1);
        Assert.assertEquals(assembly.getParts().get(1), piecePart2);
    }

    @Test
    public void testAssemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(piecePart1);
        assembly.add(subAssembly);
        Assert.assertEquals(subAssembly, assembly.getParts().get(0));
    }

    @Test
    public void testPiecePart1XML() {
        PartExtension e = piecePart1.getExtension("XML");
        XmlPartExtension xe = (XmlPartExtension) e;
        Element xml = xe.getXMLElement();
        Assert.assertEquals("PiecePart", xml.getName());
        Assert.assertEquals("997624", xml.getChild("PartNumber").getTextTrim());
        Assert.assertEquals("MyPart", xml.getChild("Description").getTextTrim());
        Assert.assertEquals(3.2, Double.parseDouble(xml.getChild("Cost").getTextTrim()), .01);
    }

    @Test
    public void testPiecePart2XML() {
        PartExtension e = piecePart2.getExtension("XML");
        XmlPartExtension xe = (XmlPartExtension) e;
        Element xml = xe.getXMLElement();
        Assert.assertEquals("PiecePart", xml.getName());
        Assert.assertEquals("7734", xml.getChild("PartNumber").getTextTrim());
        Assert.assertEquals("Hell", xml.getChild("Description").getTextTrim());
        Assert.assertEquals(666, Double.parseDouble(xml.getChild("Cost").getTextTrim()), .01);
    }

    @Test
    public void testSimpleAssemblyXML() {
        PartExtension e = assembly.getExtension("XML");
        XmlPartExtension xe = (XmlPartExtension) e;
        Element xml = xe.getXMLElement();
        Assert.assertEquals("Assembly", xml.getName());
        Assert.assertEquals("5879", xml.getChild("PartNumber").getTextTrim());
        Assert.assertEquals("MyAssembly", xml.getChild("Description").getTextTrim());
        Element parts = xml.getChild("Parts");
        List partList = parts.getChildren();
        Assert.assertEquals(0, partList.size());
    }

    @Test
    public void testAssemblyWithPartsXML() {
        assembly.add(piecePart1);
        assembly.add(piecePart2);
        PartExtension e = assembly.getExtension("XML");
        XmlPartExtension xe = (XmlPartExtension) e;
        Element xml = xe.getXMLElement();
        Assert.assertEquals("Assembly", xml.getName());
        Assert.assertEquals("5879", xml.getChild("PartNumber").getTextTrim());
        Assert.assertEquals("MyAssembly", xml.getChild("Description").getTextTrim());

        Element parts = xml.getChild("Parts");
        List partList = parts.getChildren();
        Assert.assertEquals(2, partList.size());

        Element partElement = (Element) partList.get(0);
        Assert.assertEquals("PiecePart", partElement.getName());
        Assert.assertEquals("997624", partElement.getChild("PartNumber").getTextTrim());

        partElement = (Element) partList.get(1);
        Assert.assertEquals("PiecePart", partElement.getName());
        Assert.assertEquals("7734", partElement.getChild("PartNumber").getTextTrim());
    }

    @Test
    public void testPiecePart1toCSV() {
        PartExtension e = piecePart1.getExtension("CSV");
        CsvPartExtension ce = (CsvPartExtension) e;
        String csv = ce.getCsvText();
        Assert.assertEquals("PiecePart,997624,MyPart,3.2", csv);
    }

    @Test
    public void testPiecePart2toCSV() {
        PartExtension e = piecePart2.getExtension("CSV");
        CsvPartExtension ce = (CsvPartExtension) e;
        String csv = ce.getCsvText();
        Assert.assertEquals( "PiecePart,7734,Hell,666", csv);
    }

    @Test
    public void testSimpleAssemblyCSV() {
        PartExtension e = assembly.getExtension("CSV");
        CsvPartExtension ce = (CsvPartExtension) e;
        String csv = ce.getCsvText();
        Assert.assertEquals("Assembly,5879,MyAssembly", csv);
    }

    @Test
    public void testAssemblyWithPartsCSV() {
        assembly.add(piecePart1);
        assembly.add(piecePart2);
        PartExtension e = assembly.getExtension("CSV");
        CsvPartExtension ce = (CsvPartExtension) e;
        String csv = ce.getCsvText();
        Assert.assertEquals("Assembly,5879,MyAssembly," +
                        "{PiecePart,997624,MyPart,3.2}," +
                        "{PiecePart,7734,Hell,666}"
                , csv);
    }

    @Test
    public void testBadExtension() {
        PartExtension pe = piecePart1.getExtension(
                "ThisStringDoesn'tMatchAnyException");
        Assert.assertTrue(pe instanceof BadPartExtension);
    }
}
