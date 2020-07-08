package factory.substitutablefactories;

public class OracleEmployeeFactory implements EmployeeFactory {
    @Override
    public Employee makeEmployee() {
        return new OracleEmployeeProxy();
    }

    @Override
    public TimeCard makeTimeCard() {
        return new OracleTImeCardProxy();
    }
}
