package visitor;


public interface ModemVisitor {
    void visit(HayesModem hayesModem);

    void visit(ZoomModem zoomModem);

    void visit(ErnieModem ernieModem);
}
