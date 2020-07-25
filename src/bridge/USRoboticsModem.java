package bridge;

public class USRoboticsModem implements ModemImplementation {
    @Override
    public void dial(char[] phoneNumber) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {

    }

    @Override
    public char receive() {
        return 'U';
    }
}
