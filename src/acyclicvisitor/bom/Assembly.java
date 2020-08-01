package acyclicvisitor.bom;

import java.util.ArrayList;
import java.util.List;

public class Assembly implements Part {
    private List<Part> parts = new ArrayList<>();
    private String partNumber;
    private String description;

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
        for (Part part : parts)
            part.accept(v);
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void add(Part part) {
        parts.add(part);
    }

    public List<Part> getParts() {
        return parts;
    }
}
