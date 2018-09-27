package tools;

import domain.catalogus.Catalog;
import domain.catalogus.CatalogTester;
import exception.FormatterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlFormatterCatalog {
    private Logger logger = LoggerFactory.getLogger(XmlFormatter.class);

    public CatalogTester formatToObject(String inputString) throws FormatterException {
        try {
            logger.info("Converting XML file to String...");
            String content = new String(Files.readAllBytes(Paths.get(inputString)));
            logger.info("XML file converted to String...");
            logger.info("Converting String to Object...");

            JAXBContext jaxbContext = JAXBContext.newInstance(CatalogTester.class);


            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(inputString));

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            //StringReader reader = new StringReader(content);
            CatalogTester catalogTester = (CatalogTester) unmarshaller.unmarshal(xsr);
            return catalogTester;
        } catch (Exception ex) {
            throw new FormatterException("Error during processing of the XML file...", ex);
        }
    }
}
