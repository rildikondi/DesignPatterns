package extensionobject;

import java.text.DecimalFormat;

public class CsvPiecePartExtension implements CsvPartExtension {
    private PiecePart piecePart;

    public CsvPiecePartExtension(PiecePart part) {
        piecePart = part;
    }

    public String getCsvText() {
        StringBuilder b = new StringBuilder("PiecePart,");
        b.append(piecePart.getPartNumber());
        b.append(",");
        b.append(piecePart.getDescription());
        b.append(",");
        b.append(new DecimalFormat("0.#").format(piecePart.getCost()));
        return b.toString();
    }
}
