package visitor;

public class UnixModemConfigurator implements ModemVisitor {
    @Override
    public void visit(HayesModem hayesModem) {
        hayesModem.configurationString = "&s1=4&D=3";
    }

    @Override
    public void visit(ZoomModem zoomModem) {
        zoomModem.configurationValue = 42;
    }

    @Override
    public void visit(ErnieModem ernieModem) {
        ernieModem.internalPattern = "C is too slow";
    }
}