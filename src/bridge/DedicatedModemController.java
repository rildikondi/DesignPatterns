package bridge;

public class DedicatedModemController extends ModemConnectionController {
    protected   DedicatedModemController(ModemImplementation modemImplementation) {
        super(modemImplementation);
    }

    @Override
    public void dial(char[] phoneNumber) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {
        sendImplementation(c);
    }

    @Override
    public char receive() {
        return receiveImplementation();
    }
}
