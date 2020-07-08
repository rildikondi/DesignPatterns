package observer.digitalclock.observer;

import java.util.ArrayList;
import java.util.List;

public class TimeSourceImplementation implements TimeSource {
    private List<ClockObserver> itsObservers = new ArrayList<>();

    public void notify(int hours, int mins, int secs) {
        for(ClockObserver observer : itsObservers)
        observer.update(hours, mins, secs);
    }

    @Override
    public void registerObserver(ClockObserver observer) {
        itsObservers.add(observer);
    }
}