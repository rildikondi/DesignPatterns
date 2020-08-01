package acyclicvisitor.modem;

public class UnixModemConfigurator implements HayesModemVisitor, ZoomModemVisitor, ErnieModemVisitor {
    @Override
    public void visit(ErnieModem m) {
        m.internalPattern = "C is too slow";
    }

    @Override
    public void visit(HayesModem m) {
        m.configurationString = "&s1=4&D=3";
    }

    @Override
    public void visit(ZoomModem m) {
        m.configurationValue = 42;
    }
}
