package decorator.modemdecorator;

public class LoudDialModem extends ModemDecorator {
    public LoudDialModem(Modem m) {
        super(m);
    }

    public void dial(String phoneNumber){
        getModem().setSpeakerVolume(10);
        getModem().dial(phoneNumber);
    }
}
