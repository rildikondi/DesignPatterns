package observer.digitalclock.noobserver;

public class MockTimeSink implements TimeSink {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

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
    public void setTime(int hours, int minutes, int seconds) {
        itsHours = hours;
        itsMinutes = minutes;
        itsSeconds = seconds;
    }
}
