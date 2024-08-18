package nsu.trushkov.initializer;

import nsu.trushkov.model.dto.TicketsDto;
import nsu.trushkov.model.dto.TicketDto;

/**
 * Interface for initializing {@link TicketsDto}.
 * <p>
 * Classes that implement this interface must implement initialization logic {@link TicketsDto}.
 */
public interface TicketsInitializer {

    /**
     * This method is needed to init {@link TicketsDto}.
     * @return dto that contains list {@link TicketDto}
     */
    TicketsDto init();

}
