package acyclicvisitor.bom;

public interface Part {
    String getPartNumber();

    String getDescription();

    void accept(PartVisitor v);
}
