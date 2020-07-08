package observer.digitalclock.noobserver;

public interface TimeSink {
    void setTime(int hours, int minutes, int seconds);
}
