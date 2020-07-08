package factory.spoofingfactory;

public class Payroll {

    private DatabaseFactory databaseFactory;

    public void setDatabaseFactory(DatabaseFactory databaseFactory){
        this.databaseFactory = databaseFactory;
    }

    public void calculatePay() {
        Database database = databaseFactory.make();
    }
}
