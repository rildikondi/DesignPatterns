package decorator;

public interface Modem {
    void dial(String phoneNumber);

    void setSpeakerVolume(int value);

    int getSpeakerVolume();

    String getPhoneNumber();
}
