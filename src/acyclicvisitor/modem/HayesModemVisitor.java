package acyclicvisitor.modem;

public interface HayesModemVisitor extends ModemVisitor {

    void visit(HayesModem m);
}
