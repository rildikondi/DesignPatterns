package extensionobject;


import java.util.ArrayList;
import java.util.List;

public class Assembly extends Part {
    private String partNumber;
    private String description;
    private List<Part> parts = new ArrayList<>();

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
        addExtension("CSV", new CsvAssemblyExtension(this));
        addExtension("XML", new XmlAssemblyExtension(this));
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
