package strategy.example1;

public interface Application {
    void init();
    void idle();
    void cleanup();
    boolean done();
}
