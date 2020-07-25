package adapter.modem;

public interface Modem {
    void dial(char[] phoneNumber);
    void hangup();
    void send(char c);
    char receive();
}
