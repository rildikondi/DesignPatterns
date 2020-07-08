package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {
    private List<Shape> itsShapes = new ArrayList<>();

    public void add(Shape s) {
        itsShapes.add(s);
    }

    @Override
    public void draw() {
        for (Shape shape : itsShapes) {
            shape.draw();
        }
    }
}
