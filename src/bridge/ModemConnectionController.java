package bridge;


public abstract class ModemConnectionController implements Modem, DedicatedModem {
    private ModemImplementation modemImplementation;

    protected ModemConnectionController(ModemImplementation modemImplementation) {
        this.modemImplementation = modemImplementation;
    }

    protected void dialImplementation(char[] phoneNumber) {
        modemImplementation.dial(phoneNumber);
    }

    protected void hangImplementation() {
        modemImplementation.hangup();
    }

    protected void sendImplementation(char c) {
        modemImplementation.send(c);
    }

    protected char receiveImplementation() {
        return modemImplementation.receive();
    }
}
