package singleton.example1;

public class UserDatabaseSource implements UserDatabase {
    private static UserDatabase theInstance = new UserDatabaseSource();

    public static UserDatabase getInstance() {
        return theInstance;
    }

    private UserDatabaseSource() {
    }

    @Override
    public User readUser(String userName) {
        // Some Implementation
        return null;
    }


    public void writeUser(User user) {
        // Some Implementation
    }
}
