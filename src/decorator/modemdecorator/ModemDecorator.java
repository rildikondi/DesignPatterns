package decorator.modemdecorator;

public class ModemDecorator implements Modem {
    private Modem modem;

    public ModemDecorator(Modem m) {
        modem = m;
    }

    @Override
    public void dial(String phoneNumber) {
        modem.dial(phoneNumber);
    }

    @Override
    public void hangup() {
        modem.hangup();
    }

    @Override
    public int getSpeakerVolume() {
        return modem.getSpeakerVolume();
    }

    @Override
    public void setSpeakerVolume(int value) {
        modem.setSpeakerVolume(value);
    }

    @Override
    public String getPhoneNumber() {
        return modem.getPhoneNumber();
    }

    @Override
    public void send(String exit) {

    }

    protected Modem getModem() {
        return modem;
    }
}
