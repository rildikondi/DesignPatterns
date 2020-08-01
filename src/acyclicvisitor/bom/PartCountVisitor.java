package acyclicvisitor.bom;

import java.util.Hashtable;

public class PartCountVisitor implements PartVisitor {
    private int pieceCount = 0;
    private Hashtable<String, Integer> pieceMap = new Hashtable<>();

    @Override
    public void visit(PiecePart p) {
        pieceCount++;
        String partNumber = p.getPartNumber();
        int partNumberCount = 0;
        if (pieceMap.containsKey(partNumber))
            partNumberCount = pieceMap.get(partNumber);
        partNumberCount++;
        pieceMap.put(partNumber, partNumberCount);
    }

    @Override
    public void visit(Assembly a) {

    }

    public int getPieceCount() {
        return pieceCount;
    }

    public int getPartNumberCount() {
        return pieceMap.size();
    }

    public int getCountForPart(String partNumber) {
        int partNumberCount = 0;
        if (pieceMap.containsKey(partNumber))
            partNumberCount = (int) pieceMap.get(partNumber);
        return partNumberCount;
    }
}
