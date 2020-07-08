package command.transactions;

public interface Transaction {
    void validate();
    void execute();
}
