package composite.commands;

public class Sensor {
    private Command command;

    public Sensor(Command command) {
        this.command = command;
    }

    public void onDetect() {
        command.execute();
    }
}
