package visitor;

public class ZoomModem implements Modem {
    @Override
    public void dial(String pno) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {

    }

    @Override
    public char receive() {
        return 0;
    }

    @Override
    public void accept(ModemVisitor v) {
        v.visit(this);
    }

    public int configurationValue = 0;
}