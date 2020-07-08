package observer.digitalclock.observer;

public class MockTimeSource implements TimeSource {
    private TimeSourceImplementation timeSourceImpl =
            new TimeSourceImplementation();

    public void setTime(int hours, int mins, int secs) {
        timeSourceImpl.notify(hours, mins, secs);
    }

    @Override
    public void registerObserver(ClockObserver observer) {
        timeSourceImpl.registerObserver(observer);
    }
}
