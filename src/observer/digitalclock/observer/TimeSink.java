package observer.digitalclock.observer;

public interface TimeSink {
    void setTime(int hours, int minutes, int seconds);
}
