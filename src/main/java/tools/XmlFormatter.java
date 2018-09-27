package tools;

import domain.shop.Shop;
import exception.FormatterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXB;
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
    public Shop formatToObject(String inputString) throws FormatterException {
        try {
            logger.info("Converting XML file to String...");
            File file = new File("resources/2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml");
            String content = new String(Files.readAllBytes(Paths.get("D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml")));
            logger.info("XML file converted to String.");
            //System.out.println(content);
            logger.info("Converting String to Object...");
            logger.info("test git changes in klasse");
            StringReader stringReader = new StringReader(content);
            return JAXB.unmarshal(stringReader, Shop.class);
        } catch (Exception ex) {
            throw new FormatterException("Error during conversion from XML string object Shop...", ex);
        }
    }
}

