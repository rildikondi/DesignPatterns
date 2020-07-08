package factory.staticfactory;

public class ShapesApp {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactoryImplementation();
        Shape shape = shapeFactory.makeCircle();
        double circleArea = shape.area();
        System.out.println("Circle area: " + circleArea);
    }
}
