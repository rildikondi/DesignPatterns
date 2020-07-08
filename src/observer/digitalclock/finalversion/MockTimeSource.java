package observer.digitalclock.finalversion;

public class MockTimeSource extends Subject implements TimeSource {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public void setTime(int hours, int mins, int secs) {
        itsHours = hours;
        itsMinutes = mins;
        itsSeconds = secs;
        notifyObservers();
    }

    @Override
    public int getHours() {
        return itsHours;
    }

    @Override
    public int getMinutes() {
        return itsMinutes;
    }

    @Override
    public int getSeconds() {
        return itsSeconds;
    }
}