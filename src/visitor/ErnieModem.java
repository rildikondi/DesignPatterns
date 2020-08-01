package visitor;

public class ErnieModem implements Modem {
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

    public String internalPattern = null;
}
