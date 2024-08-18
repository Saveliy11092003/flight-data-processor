package nsu.trushkov;

import nsu.trushkov.model.dto.TicketsDto;
import nsu.trushkov.handler.TicketHandler;
import nsu.trushkov.initializer.TicketsFileInitializer;
import nsu.trushkov.initializer.TicketsInitializer;
import nsu.trushkov.model.dto.model.InfoForReport;
import nsu.trushkov.writer.InfoConsoleWriter;
import nsu.trushkov.writer.InfoWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Main class contains the entry point for the application.
 * <p>
 * This class initializes components for creating a report.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * The main method is the entry point of the application.
     * <p>
     * This method generates a report.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        log.info("Application starts");

        TicketsInitializer initializer = new TicketsFileInitializer();
        TicketsDto tickets = initializer.init();
        log.info("Initialisation finished");

        InfoForReport infoForReport = new InfoForReport();
        TicketHandler handler = new TicketHandler();
        handler.handle(infoForReport, tickets);
        log.info("Info for report generated");

        InfoWriter writer = new InfoConsoleWriter();
        writer.write(infoForReport);
        log.info("Message sent");

        log.info("Application finished");
    }
}