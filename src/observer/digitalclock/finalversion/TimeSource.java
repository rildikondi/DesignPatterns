package observer.digitalclock.finalversion;

public interface TimeSource {
    int getHours();

    int getMinutes();

    int getSeconds();
}
