package extensionobject;

import org.jdom.Element;

public class XmlPiecePartExtension implements XmlPartExtension {
    private PiecePart piecePart;

    public XmlPiecePartExtension(PiecePart piecePart) {
        this.piecePart = piecePart;
    }

    @Override
    public Element getXMLElement() {
        Element element = new Element("PiecePart");
        element.addContent(new Element("PartNumber").setText(piecePart.getPartNumber()));
        element.addContent(new Element("Description").setText(piecePart.getDescription()));
        element.addContent(new Element("Cost").setText(String.valueOf(piecePart.getCost())));
        return element;
    }
}
