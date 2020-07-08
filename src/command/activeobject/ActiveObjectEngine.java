package command.activeobject;

import java.util.ArrayList;
import java.util.List;

public class ActiveObjectEngine {
    List<Command> itsCommands = new ArrayList<>();

    public void addCommand(Command c) {
        itsCommands.add(c);
    }

    public void run() {
        while (itsCommands.size() > 0) {
            Command c = itsCommands.get(0);
            itsCommands.remove(0);
            c.execute();
        }
    }
}