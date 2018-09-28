package com.indoleads.tools;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.shop.Shop;
import com.indoleads.exception.FormatterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
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
            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(inputString));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Catalog catalog = (Catalog) unmarshaller.unmarshal(xsr);
            return catalog;
        } catch (Exception ex) {
            throw new FormatterException("Error during processing of the XML file...", ex);
        }
    }
}

