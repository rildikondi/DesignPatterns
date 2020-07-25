package bridge;

public class DialModemController extends ModemConnectionController {
    protected DialModemController(ModemImplementation modemImplementation) {
        super(modemImplementation);
    }

    @Override
    public void dial(char[] phoneNumber) {
        dialImplementation(phoneNumber);
    }

    @Override
    public void hangup() {
        hangImplementation();
    }

    @Override
    public void send(char c) {

    }

    @Override
    public char receive() {
        return 0;
    }
}
