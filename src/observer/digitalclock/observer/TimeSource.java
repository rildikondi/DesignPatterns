package observer.digitalclock.observer;


public interface TimeSource {
    void registerObserver(ClockObserver observer);
}