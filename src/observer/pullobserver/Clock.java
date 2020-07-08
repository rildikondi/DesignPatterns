package observer.pullobserver;

public class Clock extends Subject {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public Clock(int itsHours, int itsMinutes, int itsSeconds) {
        this.itsHours = itsHours;
        this.itsMinutes = itsMinutes;
        this.itsSeconds = itsSeconds;
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
}
