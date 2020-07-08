package command.transactions;

public class AddEmployeeTransaction implements Transaction {
    private String name;
    private String address;
    private PayClassification payClassification;

    public AddEmployeeTransaction(String name, String address, PayClassification payClassification) {
        this.name = name;
        this.address = address;
        this.payClassification = payClassification;
    }

    @Override
    public void validate() {
        // validate name and address
        //validate also in db that the user may exist
    }

    @Override
    public void execute() {
        // add the employee to db
    }
}
