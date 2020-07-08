package singleton.example1;

public interface UserDatabase
{
    User readUser(String userName);
    void writeUser(User user);
}