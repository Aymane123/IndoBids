package tools;

import domain.catalogus.Catalog;
import domain.shop.Shop;
import exception.FormatterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A formatter that uses Castor/JAXB to transfer an XML file into a {@link Shop}
 */
public class XmlFormatter implements Formatter {
    private Logger logger = LoggerFactory.getLogger(XmlFormatter.class);

    @Override
    public Catalog formatToObject(String inputString) throws FormatterException {
        try {
            logger.info("Converting XML file to String...");
            String content = new String(Files.readAllBytes(Paths.get(inputString)));
            logger.info("XML file converted to String...");
            logger.info("Converting String to Object...");

            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(content);
            Catalog catalog = (Catalog) unmarshaller.unmarshal(reader);
            return catalog;
        } catch (Exception ex) {
            throw new FormatterException("Error during processing of the XML file...", ex);
        }
    }
}

