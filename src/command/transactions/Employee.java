package command.transactions;

public class Employee {
    private String name;
    private String address;
    private PayClassification payClassification;

    public Employee(String name, String address, PayClassification payClassification) {
        this.name = name;
        this.address = address;
        this.payClassification = payClassification;
    }
}
