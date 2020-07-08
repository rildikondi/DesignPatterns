package factory.spoofingfactory;

public class DataBaseFactoryImplementation implements DatabaseFactory {

    @Override
    public Database make() {
        return new DatabaseImplementation();
    }
}
