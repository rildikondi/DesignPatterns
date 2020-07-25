package adapter.modem;

public class DedicatedModemAdapter implements Modem {
    private DedicatedModem dedicatedModem;

    public DedicatedModemAdapter(DedicatedModem dedicatedModem) {
        this.dedicatedModem = dedicatedModem;
    }

    @Override
    public void dial(char[] phoneNumber) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {
        dedicatedModem.send(c);
    }

    @Override
    public char receive() {
        return dedicatedModem.receive();
    }
}
