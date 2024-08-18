package nsu.trushkov.model.dto;

import java.util.List;

/**
 * This class contains list of {@link TicketDto}
 * @param tickets - list of {@link TicketDto}
 */
public record TicketsDto(List<TicketDto> tickets) {

}
