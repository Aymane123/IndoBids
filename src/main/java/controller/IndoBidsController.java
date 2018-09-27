package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.InputService;
import tools.Formatter;

/**
 * Organiser of the loading process
 */
public class IndoBidsController {
    private Logger logger = LoggerFactory.getLogger(IndoBidsController.class);
    private InputService inputService;
    private Formatter formatter;

    public IndoBidsController(InputService inputService, Formatter formatter) {
        this.inputService = inputService;
        this.formatter = formatter;
    }

    public void startConverting(String inputFile) {
        try {
            logger.info("Initializing inputservice...");
            this.inputService.initialize(this.formatter);
            logger.info("Starting inputservice...");
            this.inputService.start(inputFile);
        } catch (Exception ex) {
            logger.error("Could not start converting to Shop object...");
        }
    }
}
