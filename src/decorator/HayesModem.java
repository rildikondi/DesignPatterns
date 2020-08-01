package decorator;


public class HayesModem implements Modem {
    private String phoneNumber;
    private int speakerVolume;

    @Override
    public void dial(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setSpeakerVolume(int value) {
        this.speakerVolume = value;
    }

    @Override
    public int getSpeakerVolume() {
        return speakerVolume;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
