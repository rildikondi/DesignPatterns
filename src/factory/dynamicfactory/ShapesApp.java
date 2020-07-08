package factory.dynamicfactory;

public class ShapesApp {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactoryImplementation();
        Shape shape = shapeFactory.makeShape("Circle");
        double circleArea = shape.area();
        System.out.println("Circle area: " + circleArea);
    }
}
