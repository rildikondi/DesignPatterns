package observer.digitalclock.observer;

public interface ClockObserver {
    void update(int hours, int minutes, int secs);
}
