package command.sensor;

public class Sensor {
    private Command command;

    public Sensor(Command command) {
        this.command = command;
    }

    public void onDetect() {
        command.execute();
    }
}
