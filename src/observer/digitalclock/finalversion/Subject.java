package observer.digitalclock.finalversion;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> itsObservers = new ArrayList<>();

    public void notifyObservers() {
        for (Observer observer : itsObservers)
            observer.update();
    }

    public void registerObserver(Observer observer) {
        itsObservers.add(observer);
    }
}
