package extensionobject;

import java.util.Hashtable;

public abstract class Part {
    Hashtable<String, PartExtension> extensions = new Hashtable();

    public abstract String getPartNumber();

    public abstract String getDescription();

    public void addExtension(String extensionType, PartExtension extension) {
        extensions.put(extensionType, extension);
    }

    public PartExtension getExtension(String extensionType) {
        PartExtension pe = extensions.get(extensionType);
        if (pe == null)
            pe = new BadPartExtension();
        return pe;
    }
}
