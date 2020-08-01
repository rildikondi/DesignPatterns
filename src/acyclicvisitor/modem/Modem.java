package acyclicvisitor.modem;

public interface Modem
{
    void dial(String pno);
    void hangup();
    void send(char c);
    char receive();
    void accept(ModemVisitor v);
}
