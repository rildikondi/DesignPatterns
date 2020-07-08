package observer.pushobserver;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSubject {
    private List<EmployeeObserver> employeeObserverList = new ArrayList<>();

    public void register(EmployeeObserver employeeObserver) {
        employeeObserverList.add(employeeObserver);
    }

    public void notify(EmployeeObserverHint employeeObserverHint) {
        for (EmployeeObserver employeeObserver : employeeObserverList)
            employeeObserver.update(employeeObserverHint);
    }
}
