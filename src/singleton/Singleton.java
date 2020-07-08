package singleton;

public class Singleton {
    private static Singleton theInstance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (theInstance == null)
            theInstance = new Singleton();
        return theInstance;
    }
}
