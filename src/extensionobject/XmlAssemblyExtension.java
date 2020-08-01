package extensionobject;

import org.jdom.Element;

public class XmlAssemblyExtension implements XmlPartExtension {
    private Assembly assembly;

    public XmlAssemblyExtension(Assembly assembly) {
        this.assembly = assembly;
    }

    @Override
    public Element getXMLElement() {
        Element element = new Element("Assembly");
        element.addContent(new Element("PartNumber").setText( assembly.getPartNumber()));
        element.addContent(new Element("Description").setText(assembly.getDescription()));
        Element parts = new Element("Parts");
        for (Part part : assembly.getParts()) {
            XmlPartExtension xmlPartExtension = (XmlPartExtension) part.getExtension("XML");
            parts.addContent(xmlPartExtension.getXMLElement());
        }
        element.addContent(parts);
        return element;
    }
}
