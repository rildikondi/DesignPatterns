package acyclicvisitor.bom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BOMReportTest {
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
        PiecePart p = (PiecePart) assembly.getParts().get(0);
        Assert.assertEquals(p, piecePart1);
        p = (PiecePart) assembly.getParts().get(1);
        Assert.assertEquals(p, piecePart2);
    }

    @Test
    public void assemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(piecePart1);
        assembly.add(subAssembly);
        Assert.assertEquals(subAssembly, assembly.getParts().get(0));
    }

    private class TestingVisitor implements PartVisitor {
        public List<Part> visitedParts = new ArrayList<>();

        public void visit(PiecePart p) {
            visitedParts.add(p);
        }

        public void visit(Assembly assy) {
            visitedParts.add(assy);
        }
    }

    @Test
    public void testVisitorCoverage() {
        assembly.add(piecePart1);
        assembly.add(piecePart2);
        TestingVisitor visitor = new TestingVisitor();
        assembly.accept(visitor);
        Assert.assertTrue(visitor.visitedParts.contains(piecePart1));
        Assert.assertTrue(visitor.visitedParts.contains(piecePart2));
        Assert.assertTrue(visitor.visitedParts.contains(assembly));
    }

    private Assembly cellphone;

    private void setUpReportDatabase() {
        cellphone = new Assembly("CP-7734", "Cell Phone");
        PiecePart display = new PiecePart("DS-1428", "LCD Display", 14.37);
        PiecePart speaker = new PiecePart("SP-92", "Speaker", 3.50);
        PiecePart microphone = new PiecePart("MC-28", "Microphone", 5.30);
        PiecePart cellRadio = new PiecePart("CR-56", "Cell Radio", 30);
        PiecePart frontCover = new PiecePart("FC-77", "Front Cover", 1.4);
        PiecePart backCover = new PiecePart("RC-77", "RearCover", 1.2);
        Assembly keypad = new Assembly("KP-62", "Keypad");
        Assembly button = new Assembly("B52", "Button");
        PiecePart buttonCover = new PiecePart("CV-15", "Cover", .5);
        PiecePart buttonContact = new PiecePart("CN-2", "Contact", 1.2);
        button.add(buttonCover);
        button.add(buttonContact);
        for (int i = 0; i < 15; i++)
            keypad.add(button);
        cellphone.add(display);
        cellphone.add(speaker);
        cellphone.add(microphone);
        cellphone.add(cellRadio);
        cellphone.add(frontCover);
        cellphone.add(backCover);
        cellphone.add(keypad);
    }

    @Test
    public void explodedCost() {
        setUpReportDatabase();
        ExplodedCostVisitor v = new ExplodedCostVisitor();
        cellphone.accept(v);
        Assert.assertEquals(81.27, v.getCost(), .001);
    }

    @Test
    public void partCount() {
        setUpReportDatabase();
        PartCountVisitor v = new PartCountVisitor();
        cellphone.accept(v);
        Assert.assertEquals(36, v.getPieceCount());
        Assert.assertEquals(8, v.getPartNumberCount());
        Assert.assertEquals("DS- 1428", 1, v.getCountForPart("DS-1428"));
        Assert.assertEquals("SP-92", 1, v.getCountForPart("SP-92"));
        Assert.assertEquals("MC-28", 1, v.getCountForPart("MC-28"));
        Assert.assertEquals("CR-56", 1, v.getCountForPart("CR-56"));
        Assert.assertEquals("RC-77", 1, v.getCountForPart("RC-77"));
        Assert.assertEquals("CV-15", 15, v.getCountForPart("CV-15"));
        Assert.assertEquals("CN-2", 15, v.getCountForPart("CN-2"));
        Assert.assertEquals("Bob", 0, v.getCountForPart("Bob"));

    }
}
