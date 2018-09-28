import controller.IndoBidsController;
import service.InputService;
import service.CatalogService;
import tools.Formatter;
import tools.XmlFormatter;

public class IndoBidsTester {
    public static void main(String[] args) {

        String inputFile = "D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        Formatter xmlFormatter = new XmlFormatter();
        InputService xmlInputService = new CatalogService();
        IndoBidsController indoBidsController = new IndoBidsController(xmlInputService, xmlFormatter);
        //indoBidsController.startConverting(inputFile);
        //Catalog catalog = indoBidsController.getCatalog(inputFile);
        System.out.println("break");

/*
        String inputFile = "D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        XmlFormatterCatalog xmlFormatterCatalog = new XmlFormatterCatalog();
        //System.setProperty("javax.xml.accessExternalDTD", "all");
        Catalog catalog = xmlFormatterCatalog.formatToObject(inputFile);
        System.out.println(" Shopname: " + catalog.getShop().getName()+".");
*/
    }

}
