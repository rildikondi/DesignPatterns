package factory.substitutablefactories;

public class Application {

    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new OracleEmployeeFactory();
        Employee employee = employeeFactory.makeEmployee();
        TimeCard timeCard = employeeFactory.makeTimeCard();
    }
}
