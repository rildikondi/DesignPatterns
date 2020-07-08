package factory.substitutablefactories;

public class FlatFileEmployeeFactory implements EmployeeFactory {
    @Override
    public Employee makeEmployee() {
        return new FlatFileEmployeeProxy();
    }

    @Override
    public TimeCard makeTimeCard() {
        return new FlatFileETimeCardProxy();
    }
}
