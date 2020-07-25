package bridge;

public interface ModemImplementation {
    void dial(char[] phoneNumber);
    void hangup();
    void send(char c);
    char receive();
}
