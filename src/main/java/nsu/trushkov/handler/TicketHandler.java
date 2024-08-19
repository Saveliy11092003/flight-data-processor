package nsu.trushkov.handler;

import nsu.trushkov.model.dto.TicketDto;
import nsu.trushkov.model.dto.TicketsDto;
import nsu.trushkov.model.InfoForReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is needed to get {@link InfoForReport}
 */
public class TicketHandler {

    private static final Logger log = LoggerFactory.getLogger(TicketHandler.class);

    /**
     * This method fills {@link InfoForReport}
     * @param infoForReport this is object that contains answers to questions
     * @param ticketsDto    this is object that contains ticket information
     */
    public void handle(InfoForReport infoForReport, TicketsDto ticketsDto) {
        infoForReport.setDifferenceAverageMedian(getDifference(ticketsDto));
        infoForReport.setMinTimes(getMinTimes(ticketsDto));
        log.debug("infoForReport - {}", infoForReport);
    }

    private Double getDifference(TicketsDto ticketsDto) {
        List<TicketDto> appropriateTickets = ticketsDto.tickets().stream()
        .filter((ticketDto) -> ticketDto.origin().equals("VVO") && ticketDto.destination().equals("TLV"))
                .toList();
        Double average = getAverage(appropriateTickets);
        Double median = getMedian(appropriateTickets);
        return average - median;
    }

    private Double getMedian(List<TicketDto> appropriateTickets) {
        double median;
        List<TicketDto> sortedAppropriateTickets = appropriateTickets.stream()
                .sorted(Comparator.comparingInt(TicketDto::price)).toList();
        if (sortedAppropriateTickets.size() % 2 == 1) {
            median = sortedAppropriateTickets.get(sortedAppropriateTickets.size() / 2).price();
        } else {
            double fistPartMedian = sortedAppropriateTickets.get(sortedAppropriateTickets.size() / 2).price();
            double secondPartMedian = sortedAppropriateTickets.get(sortedAppropriateTickets.size() / 2 - 1).price();
            median = (fistPartMedian + secondPartMedian) / 2;
        }
        return median;
    }

    private Double getAverage(List<TicketDto> appropriateTickets) {
        Integer sum =  appropriateTickets.stream().map(TicketDto::price).reduce(0, Integer::sum);
        return (double) sum / appropriateTickets.size();
    }

    private Map<String, Duration> getMinTimes(TicketsDto ticketsDto) {
        Map<String, Duration> minTimes = new HashMap<>();
        List<TicketDto> ticketDtoList = ticketsDto.tickets();
        for (TicketDto ticketDto : ticketDtoList) {
            if (ticketDto.origin().equals("VVO") && ticketDto.destination().equals("TLV")) {
                if (minTimes.containsKey(ticketDto.carrier())) {
                    updateDuration(minTimes, ticketDto);
                } else {
                    minTimes.put(ticketDto.carrier(), getDuration(ticketDto));
                }
            }
        }
        return minTimes;
    }

    private Duration getDuration(TicketDto ticketDto) {
        LocalDateTime dateTimeDeparture = LocalDateTime.of(ticketDto.departureDate(), ticketDto.departureTime());
        LocalDateTime dateTimeArrival = LocalDateTime.of(ticketDto.arrivalDate(), ticketDto.arrivalTime());
        return Duration.between(dateTimeDeparture, dateTimeArrival);
    }

    private void updateDuration(Map<String, Duration> minTimes, TicketDto ticketDto) {
        Duration oldDuration = minTimes.get(ticketDto.carrier());
        Duration newDuration = getDuration(ticketDto);
        if (newDuration.compareTo(oldDuration) < 0) {
            minTimes.put(ticketDto.carrier(), newDuration);
        }
    }

}
