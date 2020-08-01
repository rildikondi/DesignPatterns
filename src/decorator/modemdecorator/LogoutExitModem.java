package decorator.modemdecorator;

public class LogoutExitModem extends ModemDecorator {
    public LogoutExitModem(Modem m) {
        super(m);
    }

    @Override
    public void hangup() {
        getModem().send("Exit");
        getModem().hangup();
    }
}
