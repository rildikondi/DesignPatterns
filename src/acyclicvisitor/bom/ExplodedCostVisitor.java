package acyclicvisitor.bom;

public class ExplodedCostVisitor implements PartVisitor {
    private double cost = 0;

    public double getCost() {
        return cost;
    }

    @Override
    public void visit(PiecePart p) {
        cost += p.getCost();
    }

    @Override
    public void visit(Assembly a) {

    }
}
