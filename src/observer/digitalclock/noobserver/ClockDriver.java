package observer.digitalclock.noobserver;

public class ClockDriver {
    private final TimeSink sink;

    public ClockDriver(TimeSource source, TimeSink sink) {
        source.setDriver(this);
        this.sink = sink;
    }

    public void update(int hours, int minutes, int seconds) {
        sink.setTime(hours, minutes, seconds);
    }
}
