package observer.pushobserver;

public class SalaryObserver implements EmployeeObserver {
    private Employee employee;

    public SalaryObserver(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void update(EmployeeObserverHint employeeObserverHint) {
        switch (employeeObserverHint) {
            case HOURLY_EMPLOYEE:
                employee.setType("Hourly");
            case MONTHLY_EMPLOYEE:
                employee.setType("Monthly");
            case SALARIED_EMPLOYEE:
                employee.setType("Salaried");
        }
    }
}
