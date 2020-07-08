package factory.spoofingfactory;

public class PayRollTest implements Database, DatabaseFactory {
    private Payroll payroll = new Payroll();

    public PayRollTest(){
        payroll.setDatabaseFactory(this);
    }

    @Override
    public Database make() {
        return new DatabaseImplementation();
    }

    @Override
    public void connect() {
        System.out.println("Connected");
    }
}
