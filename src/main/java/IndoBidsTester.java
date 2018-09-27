import controller.IndoBidsController;
import service.InputService;
import service.XmlInputService;
import tools.Formatter;
import tools.XmlFormatter;

public class IndoBidsTester {
    public static void main(String[] args) {

        String inputFile = "C:\\Users\\School\\Desktop\\SCHOOL jaar 4\\STAGEPROJECT\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        Formatter xmlFormatter = new XmlFormatter();
        InputService xmlInputService = new XmlInputService();
        IndoBidsController indoBidsController = new IndoBidsController(xmlInputService, xmlFormatter);
        indoBidsController.startConverting(inputFile);

    }

}
