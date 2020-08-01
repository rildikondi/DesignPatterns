package decorator;

public class LoudDialModem implements Modem {
    private Modem itsModem;

    public LoudDialModem(Modem itsModem) {
        this.itsModem = itsModem;
    }

    @Override
    public void dial(String phoneNumber) {
        itsModem.setSpeakerVolume(10);
        itsModem.dial(phoneNumber);
    }

    @Override
    public void setSpeakerVolume(int value) {
        itsModem.setSpeakerVolume(value);
    }

    @Override
    public int getSpeakerVolume() {
        return itsModem.getSpeakerVolume();
    }

    @Override
    public String getPhoneNumber() {
        return itsModem.getPhoneNumber();
    }
}
