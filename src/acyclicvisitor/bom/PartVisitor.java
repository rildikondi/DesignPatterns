package acyclicvisitor.bom;

public interface PartVisitor
{
    void visit(PiecePart p);
    void visit(Assembly a);
}