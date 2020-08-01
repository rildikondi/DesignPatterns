package extensionobject;

public class CsvAssemblyExtension implements CsvPartExtension {
    private Assembly assembly;

    public CsvAssemblyExtension(Assembly assy) {
        assembly = assy;
    }

    public String getCsvText() {
        StringBuilder b = new StringBuilder("Assembly,");
        b.append(assembly.getPartNumber());
        b.append(",");
        b.append(assembly.getDescription());
        for (Part part : assembly.getParts()) {
            CsvPartExtension cpe = (CsvPartExtension) part.getExtension("CSV");
            b.append(",{");
            b.append(cpe.getCsvText());
            b.append("}");
        }
        return b.toString();
    }
}

