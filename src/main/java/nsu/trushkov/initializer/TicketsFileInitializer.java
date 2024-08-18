package nsu.trushkov.initializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.trushkov.model.dto.TicketDto;
import nsu.trushkov.model.dto.TicketsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * This class is needed to init {@link TicketsDto} from file .json
 */
public class TicketsFileInitializer implements TicketsInitializer {

    private static final Logger log = LoggerFactory.getLogger(TicketsFileInitializer.class);

    /**
     * This method init {@link TicketsDto} from file .json.
     * <p>
     * The method used here is objectMapper.findAndRegisterModules() for correct work with time.
     * @return object contains list of {@link TicketDto}
     */
    @Override
    public TicketsDto init() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            TicketsDto tickets = objectMapper.readValue(new File("src/main/resources/tickets.json"),
                    TicketsDto.class);
            log.debug("TicketsDto - {}", tickets);
            return tickets;
        } catch (IOException e) {
            log.error("Failed to load TicketsDto from file");
            throw new RuntimeException(e);
        }
    }
}
