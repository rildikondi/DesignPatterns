package observer.pullobserver;


public class DigitalClock implements Observer {
    private Subject subject;
    private Clock clock;
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public DigitalClock(Subject subject, Clock clock) {
        this.clock = clock;
        subject.registerObserver(this);
    }

    public int getHours() {
        return itsHours;
    }

    public int getMinutes() {
        return itsMinutes;
    }

    public int getSeconds() {
        return itsSeconds;
    }

    @Override
    public void update() {
        itsHours = clock.getHours();
        itsMinutes = clock.getMinutes();
        itsSeconds = clock.getSeconds();
    }
}
