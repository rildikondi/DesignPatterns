package factory.dynamicfactory;

public class ShapeFactoryImplementation implements ShapeFactory {

    @Override
    public Shape makeShape(String name) {
        if (name.equals("Circle"))
            return new Circle();
        else if (name.equals("Square"))
            return new Square();
        else
            try {
                throw new Exception("ShapeFactory cannot create: " + name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}
