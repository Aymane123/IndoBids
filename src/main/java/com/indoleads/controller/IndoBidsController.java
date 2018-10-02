package com.indoleads.controller;

import com.indoleads.domain.catalogus.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.indoleads.service.InputService;
import com.indoleads.tools.Formatter;

/**
 * Organiser of the loading process
 */
@Controller
public class IndoBidsController {
    private Logger logger = LoggerFactory.getLogger(IndoBidsController.class);
    private InputService inputService;
    private Formatter formatter;

    @Autowired
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

    public Catalog getCatalog(String inputFule) {
        return this.inputService.getCatalog(inputFule);
    }
}
