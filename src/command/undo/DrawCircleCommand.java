package command.undo;

import java.util.List;

public class DrawCircleCommand implements Command {
    private int circleId;

    @Override
    public void execute() {
        //tracks user mouse for click
        //when first clicked set that as a center
        //when second clicked draws the circle with radius to that point
        //add the shape to the list of shapes
        circleId = 1;
    }

    @Override
    public void undo() {
        //removes the circle form canvas
    }
}
