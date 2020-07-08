package factory.dynamicfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ShapeFactoryTest {
    ShapeFactory shapeFactory;
    ShapeFactoryImplementation shapeFactoryImplementation;

    @Before
    public void init(){
        shapeFactory = new ShapeFactoryImplementation();
    }

    @Test
    public void testCreateCircle()
    {
        Shape s = shapeFactory.makeShape("Circle");
        Assert.assertTrue(s instanceof Circle);
    }

    @Test
    public void testCreateWrongNameShape()
    {
        String shapeName= "Table";
        try {
            Shape s = shapeFactory.makeShape(shapeName);
        } catch (Exception e) {
            Assert.assertEquals("ShapeFactory cannot create:" + shapeName, e.getMessage());
        }

    }
}