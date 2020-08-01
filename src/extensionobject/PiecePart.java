package extensionobject;

public class PiecePart extends Part{
    private String partNumber;
    private String description;
    private double cost;

    public PiecePart(String partNumber, String description, double cost) {
        this.partNumber = partNumber;
        this.description = description;
        this.cost = cost;
        addExtension("CSV", new CsvPiecePartExtension(this));
        addExtension("XML", new XmlPiecePartExtension(this));
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    public double getCost() {
        return cost;
    }
}
