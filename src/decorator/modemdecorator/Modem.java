package decorator.modemdecorator;

public interface Modem {
    void dial(String phoneNumber);

    void hangup();

    void setSpeakerVolume(int value);

    int getSpeakerVolume();

    String getPhoneNumber();

    void send(String exit);
}
