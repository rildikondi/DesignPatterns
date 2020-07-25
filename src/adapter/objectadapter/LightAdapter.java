package adapter.objectadapter;

public class LightAdapter implements Switchable {
    private Light light;

    @Override
    public void turnOn() {
        light.turnOn();
    }

    @Override
    public void turnOff() {
        light.turnOff();
    }
}
